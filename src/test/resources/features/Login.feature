
Feature: Login
  As a user, I want to be able to login with username and password


  Background: User enters URL
    Given user is on the landing page


  Scenario: Only authorized users should be able to login to the application.
    When user enters with valid credentials
    Then user should verify that  Account summary page should be displayed.


  Scenario: Users with wrong username or wrong password should not be able to login.
    When user enters invalid username and password
   Then user get the error message 'Login and/or password are wrong.'
    And verify that error message is displayed