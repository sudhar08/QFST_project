describe('template spec', () => {
  beforeEach(() => {
    cy.visit("http://localhost:3000")

  })

  it("add the task using the command ", () => {
    const tasks = ['Task1', 'Task2', 'Task3', 'Task4', 'Task5', 'Task6']
    tasks.forEach((value) => {
      cy.addtodo(value);
    })

    // checking the value is added

    tasks.forEach((value) => {
      cy.findElement("todo-text").should('contain', value)
    })
    tasks.forEach((value, i) => {
      cy.findElement("todo-checkbox").eq(i).check()
      cy.findElement("todo-checkbox").eq(i).should('be.checked');
    })

    cy.findElement("delete-button").eq(1).click() 
  })

})