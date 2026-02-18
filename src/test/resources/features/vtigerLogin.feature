Feature: Login functionality

  As a registered user
  I want to login into the application
  So that I can access my dashboard

  Background:
    Given User is on the Login Page

  # ---------------- POSITIVE SCENARIO ----------------

  @PositiveLogin
  Scenario: Successful login with valid credentials
    When User enters valid username "admin"
    And User enters valid password "root"
    And User clicks on Login button
    Then User should be redirected to Dashboard page
    And Login should be successful


  # ---------------- NEGATIVE SCENARIOS ----------------

  @InvalidPassword
  Scenario: Login with valid username and invalid password
    When User enters valid username "testuser"
    And User enters invalid password "WrongPass"
    And User clicks on Login button
    Then Error message "Invalid credentials" should be displayed


  @InvalidUsername
  Scenario: Login with invalid username and valid password
    When User enters invalid username "wronguser"
    And User enters valid password "Password123"
    And User clicks on Login button
    Then Error message "Invalid credentials" should be displayed


  @EmptyCredentials
  Scenario: Login with empty username and password
    When User leaves username field empty
    And User leaves password field empty
    And User clicks on Login button
    Then Validation message "Username and Password required" should be displayed


  @EmptyPassword
  Scenario: Login with username only
    When User enters valid username "testuser"
    And User leaves password field empty
    And User clicks on Login button
    Then Validation message "Password required" should be displayed


  @EmptyUsername
  Scenario: Login with password only
    When User leaves username field empty
    And User enters valid password "Password123"
    And User clicks on Login button
    Then Validation message "Username required" should be displayed