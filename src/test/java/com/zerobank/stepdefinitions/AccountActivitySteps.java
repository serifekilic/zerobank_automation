package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivitySteps {



    AccountActivityPage accountActivityPage=new AccountActivityPage();
    @Then("user should be in {string} page")
    public void user_should_be_in_page(String string) {
        accountActivityPage.navigateTo(string);
    }

    @Then("Account drop down default option should be {string}")
    public void account_drop_down_default_option_should_be(String string) {
        Assert.assertEquals(  string, accountActivityPage.getDefaultText());
    }

    @Then("Account drop down should have the following options:")
    public void account_drop_down_should_have_the_following_options(List<String> dataTable) {
        System.out.println(dataTable);
        System.out.println(accountActivityPage.getDropdownOptions());
       Assert.assertEquals(dataTable, accountActivityPage.getDropdownOptions());
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> dataTable) {
        System.out.println(dataTable);
       Assert.assertEquals(dataTable,accountActivityPage.getTransactionsColumn());
    }



}
