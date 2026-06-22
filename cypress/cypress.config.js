import { defineConfig } from "cypress";

module.exports = defineConfig({
  e2e: {
    baseUrl: "http://localhost:3000",
    specPattern: "tests/e2e/**/*.cy.{js,jsx,ts,tsx}",
    supportFile: "tests/support/e2e.js",
    fixturesFolder: "tests/fixtures",
    screenshotsFolder: "tests/screenshots",
    videosFolder: "tests/videos",
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
  component: {
    specPattern: "tests/component/**/*.cy.{js,jsx,ts,tsx}",
    supportFile: "tests/support/component.js",
    fixturesFolder: "tests/fixtures",
    screenshotsFolder: "tests/screenshots",
    videosFolder: "tests/videos",
    devServer: {
      framework: "react",
      bundler: "webpack",
    },
  },
});
