package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends AbstractPageBase {


    @FindBy(xpath = "(//table/thead)[3]//th")
    private List<WebElement> columnNames;

    @FindBy(tagName = "h2")
    private List<WebElement> accountTypes;

    @FindBy(linkText = "Account Summary")
    private WebElement pageNames;


    public List<String> getColumnNames() {
        BrowserUtilities.waitForPageToLoad(20);
        return BrowserUtilities.getTextFromWebElements(columnNames);
    }

    public List<String> getAccountTypes() {
        BrowserUtilities.waitForPageToLoad(20);
        return BrowserUtilities.getTextFromWebElements(accountTypes);
    }

}
