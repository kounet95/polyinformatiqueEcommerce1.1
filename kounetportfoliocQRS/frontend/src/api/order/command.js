const BASE_URL = 'http://localhost:8888';

// Order API - Command
export const createOrder = async (orderData) => {
  try {
    const response = await fetch(`${BASE_URL}/order/command/create`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(orderData),
    });
    return await response.json();
  } catch (error) {
    console.error('Error creating order:', error);
    throw error;
  }
};

export const addProductToOrder = async (orderId, productData) => {
  try {
    const response = await fetch(`${BASE_URL}/order/command/${orderId}/add-product`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(productData),
    });
    return await response.json();
  } catch (error) {
    console.error(`Error adding product to order ${orderId}:`, error);
    throw error;
  }
};

export const confirmOrder = async (orderId) => {
  try {
    const response = await fetch(`${BASE_URL}/order/command/${orderId}/confirm`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return await response.json();
  } catch (error) {
    console.error(`Error confirming order ${orderId}:`, error);
    throw error;
  }
};

export const generateInvoice = async (orderId, invoiceData) => {
  try {
    const response = await fetch(`${BASE_URL}/order/command/${orderId}/generate-invoice`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(invoiceData),
    });
    return await response.json();
  } catch (error) {
    console.error(`Error generating invoice for order ${orderId}:`, error);
    throw error;
  }
};

export const payInvoice = async (invoiceId) => {
  try {
    const response = await fetch(`${BASE_URL}/order/command/invoice/${invoiceId}/pay`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return await response.json();
  } catch (error) {
    console.error(`Error paying invoice ${invoiceId}:`, error);
    throw error;
  }
};

export const startShipping = async (orderId) => {
  try {
    const response = await fetch(`${BASE_URL}/order/command/${orderId}/start-shipping`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return await response.json();
  } catch (error) {
    console.error(`Error starting shipping for order ${orderId}:`, error);
    throw error;
  }
};

export const deliverOrder = async (orderId) => {
  try {
    const response = await fetch(`${BASE_URL}/order/command/${orderId}/deliver`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return await response.json();
  } catch (error) {
    console.error(`Error delivering order ${orderId}:`, error);
    throw error;
  }
};