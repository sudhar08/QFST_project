describe('template spec', () => {
  beforeEach(() => {
    cy.visit("http://localhost:3000")
  })

  it("find the input field", () => {

    const task = ['Task1', 'Task2', 'Task3']

    task.forEach((task) => {
      cy.get('[data-cy="todo-input"]').type(task)
      cy.get('[data-cy="add-button"]').click()

    })
    cy.get('[data-cy="todo-checkbox"]').check();
    // cy.get('[data-cy="delete-button"]').click({multiple : true});

  })


})