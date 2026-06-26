// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

//sconst { click } = require("@testing-library/user-event/dist/click");

Cypress.Commands.add('addtodo', (value) => {
    cy.get('[data-cy="todo-input"]').type(value)
    cy.get('[data-cy="add-button"]').click()
});

Cypress.Commands.add('findElement', (value) => {
    return cy.get(`[data-cy="${value}"]`)
});