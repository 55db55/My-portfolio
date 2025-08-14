import { apiBaseUrl, getAuthHeaders } from '../../support/api-data'

describe('Display quiz using API', () => {
  const baseUrl = `${apiBaseUrl()}/displayquiz`;
  const quizId = '1234';

  it('should reject unauthorized quiz displaying', () => {
    cy.request({
      method: 'GET',
      url: `${baseUrl}/${quizId}`,
      failOnStatusCode: false
    })
      .then((response) => {
        expect(response.status).to.eq(403)
        expect(response.body).to.have.property('statusCode', 403)
      })
  })

  it('should display quiz using API', () => {
    cy.request({
      method: 'GET',
      url: `${baseUrl}/${quizId}`,
      headers: getAuthHeaders()
    })
      .then((response) => {
        expect(response.status).to.eq(200)
        expect(response.body).to.have.property('id')
        expect(response.body).to.have.property('name')
        expect(response.body).to.have.property('isPublished')
        expect(response.body).to.have.property('status')
      })
  })
})