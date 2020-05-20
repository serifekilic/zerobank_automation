
Feature: Find Transactions in Account Activity

  Background:
    Given user is on the landing page
    When user enters with valid credentials


  Scenario: Search date range
    Given the user accesses the Find Transactions tab
    When the user enters date range from “'2012-09-01'” to “'2012-09-06'”
    And clicks search
    Then results table should only show transactions dates between “'2012-09-01'” to “'2012-09-06'”
    And the results should be sorted by most recent date
   When the user enters date range from “'2012-09-02'” to “'2012-09-06'”
    And clicks search
    Then results table should only show transactions dates between “'2012-09-02'” to “'2012-09-06'”
    And the results table should only not contain transactions dated “'2012-09-01'”
# results table only show dates btw 12-9-6 and 12-9-5 ,
# there is a bug



  Scenario: Search description
    Given the user accesses the Find Transactions tab
    When the user enters description “ONLINE”
    And clicks search
    Then results table should only show descriptions containing “ONLINE”
    When the user enters description “OFFICE”
    And clicks search
    Then results table should only show descriptions containing “OFFICE”
    But results table should not show descriptions containing “ONLINE”


  Scenario: Search description case insensitive
    Given the user accesses the Find Transactions tab
    When the user enters description “ONLINE”
    And clicks search
    Then results table should only show descriptions containing “ONLINE”
    When the user enters description “online”
    And clicks search
    Then results table should only show descriptions containing “ONLINE”
  #this is the bug, result table does not show anything
  #(it is supposed to show ONLINE)



  Scenario: Type
    Given the user accesses the Find Transactions tab
    And clicks search
    Then results table should show at least one result under Deposit
    Then results table should show at least one result under Withdrawal
    When user selects type “Deposit”
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal
    When user selects type “Withdrawal”
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit