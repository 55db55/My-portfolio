export const apiBaseUrl = () => {
  return Cypress.env('apiBaseUrl');
};

export const getAuthHeaders = () => {
  const token = Cypress.env('apiToken');
  if (!token) {
    return {};
  }
  return { Authorization: `Bearer ${token}` };
};