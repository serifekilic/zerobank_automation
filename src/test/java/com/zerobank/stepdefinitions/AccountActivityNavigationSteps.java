package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationSteps {


   AccountActivityPage accountActivityPage=new AccountActivityPage();

    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        accountSummaryPage.navigateTo("Brokerage");
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
       Assert.assertEquals("Account Activity", accountActivityPage.getSubTitle("Account Activity"));
    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        Assert.assertEquals( "Brokerage",accountActivityPage.getDefaultText());
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        accountSummaryPage.navigateTo("Checking");
    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        Assert.assertEquals( "Checking",accountActivityPage.getDefaultText());
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        accountSummaryPage.navigateTo("Credit Card");
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        Assert.assertEquals( "Credit Card",accountActivityPage.getDefaultText());
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        accountSummaryPage.navigateTo("Loan");

    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        Assert.assertEquals( "Loan",accountActivityPage.getDefaultText());
    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        accountSummaryPage.navigateTo("Savings");
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        Assert.assertEquals( "Savings",accountActivityPage.getDefaultText());
    }





}
