import { apiBaseUrl, getAuthHeaders } from '../../support/api-data'

describe('Quiz Creation API', () => {
  it('should reject unauthorized requests', () => {
    cy.request({
      method: 'POST',
      url: `${apiBaseUrl()}/new/quiz/ai`,
      failOnStatusCode: false,
      body: {
        name: 'ai quiz',
        users: [],
        sources: [],
        dateFrom: '07/13/2025',
        dateTo: '08/13/2025',
        questionsCount: 5,
        all_selected: true,
        publish: false
      }
    })
      .then((response) => {
        expect(response.status).to.eq(403)
        expect(response.body).to.have.property('statusCode', 403)
      })
  })

  it('should create AI quiz', () => {
    cy.request({
      method: 'POST',
      url: `${apiBaseUrl()}/new/quiz/ai`,
      headers: getAuthHeaders(),
      body: {
        name: 'ai quiz',
        users: [],
        sources: [],
        dateFrom: '07/13/2025',
        dateTo: '08/13/2025',
        questionsCount: 5,
        all_selected: true,
        publish: false
      }
    })
      .then((response) => {
        expect(response.status).to.eq(201)
        expect(response.body).to.have.property('id')
        expect(response.body).to.have.property('name')
        expect(response.body).to.have.property('isPublished')
        expect(response.body.isPublished).to.be.false
        expect(response.body).to.have.property('status')
      })
  })
})