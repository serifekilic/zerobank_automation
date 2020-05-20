package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class PayBillsPage extends AbstractPageBase {

    Random random = new Random();

    @FindBy(xpath = "//select[@id='sp_payee']")
    private WebElement payee;

    @FindBy(id = "sp_account")
    private WebElement account;

    @FindBy(id = "sp_amount")
    private WebElement amount;

    @FindBy(id = "sp_date")
    private WebElement date;

    @FindBy(xpath = "// table/tbody/tr/ td")
    private List<WebElement> dateOptions;

    @FindBy(id = "sp_description")
    private WebElement description;

    @FindBy(id = "pay_saved_payees")
    private WebElement payBtn;

    @FindBy(id = "alert_content")
    private WebElement message;

    @FindBy(id = "np_new_payee_name")
    private WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    private WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    private WebElement payeeAccount;

    @FindBy(xpath = "//div/input[@name='details']")
    private WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    private WebElement addBtn;

    @FindBy(id = "pc_currency")
    private WebElement currency;

    @FindBy(id = "pc_calculate_costs")
    private WebElement calculateCost;

    @FindBy(id = "pc_amount")
    private WebElement enterAmount;


    public String getSmallText() {
        String text = Driver.getDriver().findElement(By.id("sp_amount")).getAttribute("validationMessage");
        return text;
    }

    public void selectCurrency() {
        currency.click();
        Select select = new Select(currency);
        select.selectByIndex(13);
    }

    public void setEnterAmount() {
        enterAmount.sendKeys("10000");
    }

    public void clickCalculateCost() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(calculateCost)).click();
    }

    public void clickCurrency() {
        currency.click();
    }

    public List<String> getCurrency() {
        BrowserUtilities.waitForPageToLoad(20);
        Select select = new Select(currency);
        List<WebElement> list = select.getOptions();
        return BrowserUtilities.getTextFromWebElements(list);
    }

    public void clickAdd() {
        addBtn.click();
    }

    public void setPayeeName(String name) {
        payeeName.sendKeys(name);
    }

    public void setPayeeAddress(String address) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("np_new_payee_address"))).sendKeys(address);

    }

    public void setPayeeAccount(String account) {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("np_new_payee_account"))).sendKeys(account);
    }

    public void setPayeeDetails(String details) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/input[@name='details']"))).sendKeys(details);

    }

    public String getMessage() {
        BrowserUtilities.waitForPageToLoad(20);
        return wait.until(ExpectedConditions.visibilityOf(message)).getText();
    }

    public void clickPayBtn() {
        BrowserUtilities.waitForPageToLoad(20);
        payBtn.click();
        BrowserUtilities.wait(3);
    }

    public void enterDescription() {
        BrowserUtilities.waitForPageToLoad(20);
        description.sendKeys("Education fee");
    }

    public void enterWrongDate() {
        BrowserUtilities.waitForPageToLoad(20);
        date.sendKeys("2020-yili");
    }

    public void enterDate() {
        BrowserUtilities.waitForPageToLoad(20);
        date.sendKeys("2020-04-01");
    }

    public void enterWrongAmount() {
        BrowserUtilities.waitForPageToLoad(20);
        amount.sendKeys("50AS");
    }

    public void enterAmount() {
        BrowserUtilities.waitForPageToLoad(20);
        amount.sendKeys("500");
    }

    public void enterAccount() {
        BrowserUtilities.waitForPageToLoad(20);
        account.click();
        Select select = new Select(account);
        int ran = random.nextInt(select.getOptions().size());
        select.selectByIndex(ran);
    }

    public void enterPayee() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='sp_payee']"))).click();
        Select select = new Select(payee);
        int ran = random.nextInt(select.getOptions().size());
        select.selectByIndex(ran);
    }
}
