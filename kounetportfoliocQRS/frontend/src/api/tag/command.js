const BASE_URL = 'http://localhost:8888';

// Tag API - Command
export const createTag = async (tagData) => {
  try {
    const response = await fetch(`${BASE_URL}/tag/command/create`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(tagData),
    });
    return await response.json();
  } catch (error) {
    console.error('Error creating tag:', error);
    throw error;
  }
};

export const getTagEvents = async (id) => {
  try {
    const response = await fetch(`${BASE_URL}/tag/command/events/${id}`);
    return await response.json();
  } catch (error) {
    console.error(`Error fetching tag events ${id}:`, error);
    throw error;
  }
};