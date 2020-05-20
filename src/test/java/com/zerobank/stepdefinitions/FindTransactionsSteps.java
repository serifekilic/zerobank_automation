package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class FindTransactionsSteps {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.navigateTo("Account Activity");
        accountActivityPage.navigateTo("Find Transactions");
    }

    @When("the user enters description “ONLINE”")
    public void the_user_enters_description_ONLINE() {
        accountActivityPage.sendDescription("ONLINE");
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.clickFind();
    }


    @Then("results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_ONLINE() {
        Assert.assertTrue(accountActivityPage.checkDescription("ONLINE"));
    }

    @When("the user enters description “OFFICE”")
    public void the_user_enters_description_OFFICE() {
        accountActivityPage.sendDescription("OFFICE");
    }

    @Then("results table should only show descriptions containing “OFFICE”")
    public void results_table_should_only_show_descriptions_containing_OFFICE() {
        Assert.assertTrue(accountActivityPage.checkDescription("OFFICE"));
    }

    @Then("results table should not show descriptions containing “ONLINE”")
    public void results_table_should_not_show_descriptions_containing_ONLINE() {
        Assert.assertFalse(accountActivityPage.checkDescription("ONLINE"));
    }

    @When("the user enters description “online”")
    public void the_user_enters_description_online() {
        accountActivityPage.sendDescription("online");
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue(accountActivityPage.atLeastOneDeposit());
    }

    @When("user selects type “Deposit”")
    public void user_selects_type_Deposit() {
        accountActivityPage.selectType("Deposit");
        accountActivityPage.clickFind();
    }


    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertTrue(accountActivityPage.atLeastOneWithdrawal());
    }

    @When("user selects type “Withdrawal”")
    public void user_selects_type_Withdrawal() {
        accountActivityPage.selectType("Withdrawal");
        accountActivityPage.clickFind();
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(accountActivityPage.atLeastOneWithdrawal());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue(accountActivityPage.atLeastOneDeposit());
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue(accountActivityPage.isMostRecentDate());
    }

    @When("the user enters date range from “{string}” to “{string}”")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        accountActivityPage.enterDates(string, string2);
    }

    @Then("results table should only show transactions dates between “{string}” to “{string}”")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        List<String> lis = accountActivityPage.getTransactionDates();
        System.out.println(lis);
        System.out.println(string + " " + string2);
        Assert.assertEquals(lis.get(0), string2);
        Assert.assertEquals(lis.get(1), string);
    }

    @Then("the results table should only not contain transactions dated “{string}”")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        Assert.assertTrue(accountActivityPage.notContainDate(string));
    }


}
