
Feature: Add new payee under pay bills


  Background:
    Given user is on the landing page
    When user enters with valid credentials


  Scenario: Add a new payee
    Given Add New Payee tab
    And creates new payee using following information

      | Payee Name                               | Payee Address                    | Account  | Payee details |
      | The Law Offices of Hyde, Price & Scharks | 100 Same st, Anytown, USA, 10001 | Checking | XYZ account   |


    Then message 'The new payee The Law Offices of Hyde, Price & Scharks was successfully created.' should be displayed


