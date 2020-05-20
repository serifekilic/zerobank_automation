package com.zerobank.pages;


import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class AccountActivityPage extends AbstractPageBase {


    @FindBy(id = "aa_accountId")
    private WebElement dropDown;

    @FindBy(xpath = "//table/thead/tr/th")
    private List<WebElement> transactionsColumn;

    @FindBy(id = "aa_fromDate")
    private WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    private WebElement dateTo;

    @FindBy(css = "#find_transactions_form > div.pull-right > button")
    private WebElement findBtn;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr[1]/td[1]")
    private WebElement resultDateTo;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr[3]/td[1]")
    private WebElement resultDateFrom;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    private List<WebElement> onlineDescColumn;

    @FindBy(id = "aa_description")
    private WebElement description;

    @FindBy(id = "aa_type")
    private WebElement type;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    private List<WebElement> deposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    private List<WebElement> withdrawal;


    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    private List<WebElement> dateColumn;


    public boolean isMostRecentDate() {
        String date1 = dateTo.getAttribute("value");
        String date2 = dateColumn.get(0).getText();
        return date1.equals(date2);
    }

    public boolean notContainDate(String date) {
        List<String> list = BrowserUtilities.getTextFromWebElements(dateColumn);
        for (String each : list) {
            if (!each.equals(date)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getTransactionDates() {
        List<String> list = new ArrayList<>();
        list.add(dateColumn.get(0).getText());
        list.add(dateColumn.get(dateColumn.size() - 1).getText());
        return list;
    }

    public boolean atLeastOneWithdrawal() {
        BrowserUtilities.waitForPageToLoad(20);
        if (withdrawal.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean atLeastOneDeposit() {
        BrowserUtilities.waitForPageToLoad(20);
        if (deposit.size() > 0) {
            return true;
        }
        return false;
    }

    public void selectType(String string) {
        BrowserUtilities.waitForPageToLoad(20);
        Select select = new Select(type);
        select.selectByVisibleText(string);
    }

    public void sendDescription(String str) {
        BrowserUtilities.waitForPageToLoad(20);
        description.clear();
        description.sendKeys(str);
    }

    public boolean checkDescription(String string) {
        BrowserUtilities.waitForPageToLoad(20);
        List<String> list = BrowserUtilities.getTextFromWebElements(onlineDescColumn);
        for (String each : list) {
            if (each.contains(string)) {
                return true;
            }
        }
        return false;
    }

    public void clickFind() {
        BrowserUtilities.waitForPageToLoad(20);
        findBtn.click();
        BrowserUtilities.wait(1);
    }

    public void enterDates(String date1, String date2) {
        dateFrom.clear();
        dateFrom.sendKeys(date1);
        dateTo.clear();
        dateTo.sendKeys(date2);
    }

    public List<String> getTransactionsColumn() {
        BrowserUtilities.waitForPageToLoad(20);
        return BrowserUtilities.getTextFromWebElements(transactionsColumn);
    }

    public String getDefaultText() {
        BrowserUtilities.waitForPageToLoad(20);
        Select select = new Select(dropDown);
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getDropdownOptions() {
        BrowserUtilities.waitForPageToLoad(20);
        Select select = new Select(dropDown);
        List<WebElement> options = select.getOptions();
        List<String> allOptions = BrowserUtilities.getTextFromWebElements(options);
        Set<String> unique = new HashSet<>();
        for (String each : allOptions) {
            unique.add(each);
        }
        List<String> list = new ArrayList<>();
        for (String each : unique) {
            list.add(each);
        }
        return list;
    }
}