const BASE_URL = 'http://localhost:8888';

// Purchase API - Query
export const getAllPurchases = async () => {
  try {
    const response = await fetch(`${BASE_URL}/api/purchases`);
    return await response.json();
  } catch (error) {
    console.error('Error fetching purchases:', error);
    throw error;
  }
};

export const getPagedPurchases = async (page = 0, size = 10) => {
  try {
    const response = await fetch(`${BASE_URL}/api/purchases/paged?page=${page}&size=${size}`);
    return await response.json();
  } catch (error) {
    console.error(`Error fetching paged purchases:`, error);
    throw error;
  }
};

export const getPurchaseById = async (id) => {
  try {
    const response = await fetch(`${BASE_URL}/api/purchases/${id}`);
    return await response.json();
  } catch (error) {
    console.error(`Error fetching purchase ${id}:`, error);
    throw error;
  }
};