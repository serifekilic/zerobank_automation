
Feature: Pay Bill Page


  Background:
    Given user is on the landing page
    When user enters with valid credentials
    Then user should be in "Pay Bills" page

  Scenario: Account Summary page  information
    Then user verifies that page title is "Zero - Pay Bills"
    When user completes a successful Pay operation
    Then user get the message 'The payment was successfully submitted.'


  Scenario: user tries to make a payment
    Then user verifies that page title is "Zero - Pay Bills"
    When user tries to make a payment without entering the amount or date
    Then user get some message 'Please fill out this field.'


      Scenario: user tries to make a payment
        Then amount field should not accept alphabetical or special characters
        Then Date field should not accept alphabetical characters
        Then user get some message 'Please fill out this field.'

#@3 has a bug. bec, we can enter alphabetical characters into amount.
  #Date field does not accept alphabetical characters but, we do not get warning message.
  #it give 'The payment was successfully submitted.' message.


