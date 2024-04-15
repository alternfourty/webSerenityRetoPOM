Feature: Create user account
  As a user i want to create an account in the webstore
  for blaze.
  Scenario: User account creation
    Given User is able to access blaze webstore
    And clicks on SignUp links
    When The user fills the data for the new account
    Then I should see a browser alert with a successful message