/// <reference types="cypress" />

import { standardSetup } from "../support/before-each";

describe("Authentication", () => {
  it("should allow user to log in with valid credentials", () => {
    standardSetup();
  });
});