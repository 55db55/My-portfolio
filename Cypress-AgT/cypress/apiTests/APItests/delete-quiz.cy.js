import { apiBaseUrl, getAuthHeaders } from '../../support/api-data'

describe('Delete quiz using API', () => {
    const quizId = '1234';
    const baseUrl = `${apiBaseUrl()}/delete`;

    it('should reject unauthorized deletion attempts', () => {
        cy.request({
            method: 'DELETE',
            url: `${baseUrl}/${quizId}`,
            failOnStatusCode: false
        })
            .then((response) => {
                expect(response.status).to.eq(403)
                expect(response.body).to.have.property('statusCode', 403)
            })
    })

    it('should delete quiz', () => {
        cy.request({
            method: 'DELETE',
            url: `${baseUrl}/${quizId}`,
            headers: getAuthHeaders()
        })
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).to.have.property('success')
                expect(response.body.success).to.be.true
            })
    })
})