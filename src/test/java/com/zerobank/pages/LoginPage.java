package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageBase {


    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submit;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement login;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement errorMessage;

    public String getErrorMessage() {
        BrowserUtilities.waitForPageToLoad(20);
        return errorMessage.getText();
    }
    public void login() {
        BrowserUtilities.waitForPageToLoad(20);
        login.sendKeys(ConfigurationReader.getProperty("username"));
        BrowserUtilities.wait(1);
        password.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtilities.wait(1);
        submit.click();
    }
    public void login(String username, String code) {
        BrowserUtilities.waitForPageToLoad(20);
        login.sendKeys(username);
        BrowserUtilities.wait(1);
        password.sendKeys(code);
        BrowserUtilities.wait(1);
        submit.click();
    }


}
