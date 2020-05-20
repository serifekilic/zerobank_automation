package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsSteps {

    PayBillsPage payBillsPage = new PayBillsPage();


    @When("user completes a successful Pay operation")
    public void user_completes_a_successful_Pay_operation() {
        payBillsPage.enterPayee();
        payBillsPage.enterAccount();
        payBillsPage.enterAmount();
        payBillsPage.enterDate();
        payBillsPage.enterDescription();
        payBillsPage.clickPayBtn();
    }

    @Then("user get the message {string}")
    public void user_get_the_message(String string) {
        Assert.assertEquals(string, payBillsPage.getMessage());
    }

    @When("user tries to make a payment without entering the amount or date")
    public void user_tries_to_make_a_payment_without_entering_the_amount_or_date() {
        payBillsPage.enterPayee();
        payBillsPage.enterAccount();
        payBillsPage.enterDescription();
        payBillsPage.clickPayBtn();
    }

    @Then("user get some message {string}")
    public void user_get_some_message(String string) {
        System.out.println(payBillsPage.getSmallText());
        Assert.assertEquals(string, payBillsPage.getSmallText());
    }

    @Then("amount field should not accept alphabetical or special characters")
    public void amount_field_should_not_accept_alphabetical_or_special_characters() {
        payBillsPage.enterWrongAmount();
        payBillsPage.clickPayBtn();
    }

    @Then("Date field should not accept alphabetical characters")
    public void date_field_should_not_accept_alphabetical_characters() {
        payBillsPage.enterWrongDate();
        payBillsPage.clickPayBtn();

    }
}
