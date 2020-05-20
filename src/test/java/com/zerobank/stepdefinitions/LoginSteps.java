package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        System.out.println("Open login page");
        String url = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(url);
        loginPage.setSignin();
    }

    @When("user enters with valid credentials")
    public void user_enters_with_valid_credentials() {
        loginPage.login();
    }


    @Then("user should verify that  Account summary page should be displayed.")
    public void user_should_verify_that_Account_summary_page_should_be_displayed() {
        Assert.assertTrue(loginPage.getTitle().contains("Account Summary"));
    }

    @Then("user get the error message 'Login and\\/or password are wrong.")
    public void user_get_the_error_message_Login_and_or_password_are_wrong() {

    }

    @Then("verify that error message is displayed")
    public void verify_that_error_message_is_displayed() {
        loginPage.getErrorMessage();
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        String string1 = "";
        String string2 = "";
        loginPage.login(string1, string2);
    }

    @Then("user get the error message {string}")
    public void user_get_the_error_message(String string) {
        Assert.assertEquals(string, loginPage.getErrorMessage());
    }


}
