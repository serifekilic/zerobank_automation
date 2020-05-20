package com.zerobank.stepdefinitions;

import com.zerobank.pages.OnlineStatementsPage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StatementsAndDocumentsSteps {

    OnlineStatementsPage onlineStatementsPage = new OnlineStatementsPage();


    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_Statements_Documents_tab() {
        onlineStatementsPage.navigateTo("Online Statements");
    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer int1) {
        System.out.println("Select recent statements year:: " + int1);
        onlineStatementsPage.selectStatements(int1);
    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(Integer int1) {
        Assert.assertEquals(int1, onlineStatementsPage.numOfStatements());
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String year) {
        onlineStatementsPage.clickStatement(year);

    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
        assertTrue(BrowserUtilities.isFileDownloaded(string));
    }

    @Then("type should be {string} for the file {string}")
    public void type_should_be_for_the_file(String type, String fileName) {
        assertEquals(type, BrowserUtilities.verifyFileExtension(type, fileName));
    }
}
