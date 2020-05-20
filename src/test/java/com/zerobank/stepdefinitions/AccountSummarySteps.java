package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;


public class AccountSummarySteps {


    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    LoginPage loginPage=new LoginPage();

    @When("user should be in Accounts Summary page")
    public void user_should_be_in_Accounts_Summary_page() {
        System.out.println("User is in the Account Summary Page");

    }

    @Then("user verifies that page title is {string}")
    public void user_verifies_that_page_title_is(String string) {
        System.out.println(accountSummaryPage.getTitle());
        System.out.println(loginPage.getTitle());
        Assert.assertEquals(string, Driver.getDriver().getTitle());
    }

    @Then("account summary page should have the following options")
    public void account_summary_page_should_have_the_following_options(List<String> dataTable) {
        System.out.println(dataTable);
        Assert.assertEquals(dataTable,accountSummaryPage.getAccountTypes());
    }
    @Then("Credit Accounts table should have the following columns")
    public void credit_Accounts_table_should_have_the_following_columns(List<String> dataTable) {
        System.out.println(dataTable);
       Assert.assertEquals(dataTable, accountSummaryPage.getColumnNames());
    }

}
