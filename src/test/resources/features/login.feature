Feature: User login on webpage
  As a user i want to log in into the web store with my
  created account
  Background:
    Given User is able to access blaze webstore
  @LogInSuccessful
  Scenario: User successful login
    When The user clicks on the login button and fills the user and the password
    Then I should see the page welcome message with the username on the navigation menu
