import { apiBaseUrl, getAuthHeaders } from '../../support/api-data'

describe('Quiz publishing using API', () => {
  const baseUrl = `${apiBaseUrl()}/quiz`;
  const quizId = '1234';
  const endpoint = 'set-publish';

  it('should reject unauthorized publishing attempts', () => {
    cy.request({
      method: 'POST',
      url: `${baseUrl}/${quizId}/${endpoint}`,
      failOnStatusCode: false
    })
      .then((response) => {
        expect(response.status).to.eq(403)
        expect(response.body).to.have.property('statusCode', 403)
      })
  })

  it('should publish quiz', () => {
    cy.request({
      method: 'POST',
      url: `${baseUrl}/${quizId}/${endpoint}`,
      headers: getAuthHeaders()
    })
      .then((response) => {
        expect(response.status).to.eq(201)
        expect(response.body).to.have.property('success')
        expect(response.body.success).to.be.true
      })
  })
})