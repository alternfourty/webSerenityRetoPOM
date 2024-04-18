Feature: Create user account
  As a user i want to create an account in the webstore
  for blaze.
  @AccountCreated
  Scenario Outline: User account creation
    Given User is able to access blaze webstore
    And clicks on SignUp links
    When The user fills the data for the new account
      |User|Password|
      |<user>|<password>|
    Then I should see a browser alert with a successful message
    Examples:
      |user|password|
      |newUser9875QA|th1sP4ssw0rd3761|