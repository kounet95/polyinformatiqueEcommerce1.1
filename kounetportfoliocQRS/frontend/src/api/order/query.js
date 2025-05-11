const BASE_URL = 'http://localhost:8888';

// Order API - Query
export const getAllOrders = async () => {
  try {
    const response = await fetch(`${BASE_URL}/api/orders`);
    return await response.json();
  } catch (error) {
    console.error('Error fetching orders:', error);
    throw error;
  }
};

export const getPagedOrders = async (page = 0, size = 10) => {
  try {
    const response = await fetch(`${BASE_URL}/api/orders/paged?page=${page}&size=${size}`);
    return await response.json();
  } catch (error) {
    console.error(`Error fetching paged orders:`, error);
    throw error;
  }
};

export const getOrderById = async (id) => {
  try {
    const response = await fetch(`${BASE_URL}/api/orders/${id}`);
    return await response.json();
  } catch (error) {
    console.error(`Error fetching order ${id}:`, error);
    throw error;
  }
};