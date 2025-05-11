const BASE_URL = 'http://localhost:8888';

// Purchase API - Command
export const receivePurchase = async (purchaseData) => {
  try {
    const response = await fetch(`${BASE_URL}/purchase/command/receive`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(purchaseData),
    });
    return await response.json();
  } catch (error) {
    console.error('Error receiving purchase:', error);
    throw error;
  }
};