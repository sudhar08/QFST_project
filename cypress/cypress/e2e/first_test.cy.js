describe('template spec', () => {
  it('open the app page', () => {
    cy.visit('http://localhost:3000')
  })

  // Tetst funcation 
  it('verfiies page heading ', () => {
    cy.visit('http://localhost:3000')
    cy.contains("Todo List")
  })



})