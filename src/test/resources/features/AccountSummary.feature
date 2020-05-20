
Feature: Account summary
  As a user, I should be able to see account details.


  Scenario: Account Summary page  information
    When user is on the landing page
    Then user enters with valid credentials
    Then user should be in Accounts Summary page
    Then user verifies that page title is "Zero - Account Summary"
    Then account summary page should have the following options
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And Credit Accounts table should have the following columns
      | Account     |
      | Credit Card |
      | Balance     |
