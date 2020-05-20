
Feature: Account Activity Page
  As a user, I should be able to see and work on this page

  Scenario: Account Activity Page information
    Given user is on the landing page
    When user enters with valid credentials
    Then user should be in "Account Activity" page
    Then user verifies that page title is "Zero - Account Activity"
    And Account drop down default option should be 'Savings'
    And Account drop down should have the following options:
      | Credit Card |
      | Savings     |
      | Loan        |
      | Checking    |
      | Brokerage   |

    And Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |