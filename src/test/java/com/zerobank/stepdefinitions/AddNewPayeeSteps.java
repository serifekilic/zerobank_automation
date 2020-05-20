package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddNewPayeeSteps {


    PayBillsPage payBillsPage=new PayBillsPage();


    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
      payBillsPage.navigateTo("Pay Bills");
      payBillsPage.navigateTo("Add New Payee");

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
   payBillsPage.setPayeeName(dataTable.get(0).get("Payee Name"));
   payBillsPage.setPayeeAddress(dataTable.get(0).get("Payee Address"));
   payBillsPage.setPayeeAccount(dataTable.get(0).get("Account"));
   payBillsPage.setPayeeDetails(dataTable.get(0).get("Payee details"));
   payBillsPage.clickAdd();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        System.out.println(payBillsPage.getMessage());
        Assert.assertEquals(string,payBillsPage.getMessage() );
    }

}
