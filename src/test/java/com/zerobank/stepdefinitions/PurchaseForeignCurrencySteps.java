package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PurchaseForeignCurrencySteps {

    PayBillsPage payBillsPage=new PayBillsPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
       payBillsPage.navigateTo("Pay Bills");
       payBillsPage.navigateTo("Purchase Foreign Currency");
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        payBillsPage.clickCurrency();
        System.out.println(dataTable);
        System.out.println(payBillsPage.getCurrency());
        Assert.assertTrue( payBillsPage.getCurrency().containsAll(dataTable));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.setEnterAmount();
       payBillsPage.clickCalculateCost();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        System.out.println(payBillsPage.getSmallText());
      Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values."
              ,payBillsPage.getSmallText());
    }
    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.selectCurrency();
        payBillsPage.clickCalculateCost();
    }



}
