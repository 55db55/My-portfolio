import { apiBaseUrl, getAuthHeaders } from '../../support/api-data'


describe('Resend quiz to agent using API', () => {
  const baseUrl = `${apiBaseUrl()}/quiz`;
  const agentId = '5678';
  const quizId = '1234';
  const endpoint = 'resend';

  it('should reject unauthorized resend attempts', () => {
    cy.request({
      method: 'POST',
      url: `${baseUrl}/agent/${agentId}/${quizId}/${endpoint}`,
      failOnStatusCode: false
    })
      .then((response) => {
        expect(response.status).to.eq(403)
        expect(response.body).to.have.property('statusCode', 403)
      })
  })

  it('should resend quiz', () => {
    cy.request({
      method: 'POST',
      url: `${baseUrl}/agent/${agentId}/${quizId}/${endpoint}`,
      headers: getAuthHeaders()
    })
      .then((response) => {
        expect(response.status).to.eq(201)
        expect(response.body).to.have.property('success')
        expect(response.body.success).to.be.true
      })
  })
})