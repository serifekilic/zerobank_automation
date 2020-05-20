package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);


    @FindBy(id = "signin_button")
    private WebElement signin;


    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }


    public String getTitle() {

        return Driver.getDriver().getTitle();
    }

    public String getSubTitle(String subTitle) {
        WebElement module = Driver.getDriver().findElement(By.xpath("//a[text()='" + subTitle + "']"));
        return module.getText();
    }

    public void navigateTo(String accountPageName) {
        BrowserUtilities.waitForPageToLoad(20);
        WebElement accountPage = Driver.getDriver().findElement(By.linkText(accountPageName));
        BrowserUtilities.wait(3);
        accountPage.click();
        BrowserUtilities.wait(5);
    }

    public void setSignin() {
        signin.click();
    }


}
