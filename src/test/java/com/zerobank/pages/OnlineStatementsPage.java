package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;

import java.util.List;


public class OnlineStatementsPage extends AbstractPageBase {
    private String fileName;

    @FindBy(xpath = "//ul[@class='nav nav-pills']/li")
    private List<WebElement> recentStatements;

    @FindBy(xpath = "(//table/tbody)[4]/tr")
    private List<WebElement> pdfStatements;


    public void clickStatement(String year) {
        BrowserUtilities.waitForPageToLoad(20);
        WebElement statement= Driver.getDriver().findElement(By.linkText(year));
        BrowserUtilities.clickWithJS(statement);
        BrowserUtilities.wait(5);
    }

    public void selectStatements(int year) {

        switch (year) {
            case 2009:
                recentStatements.get(3).click();
                break;
            case 2010:
                recentStatements.get(2).click();
                break;
            case 2011:
                recentStatements.get(1).click();
                break;
            case 2012:
                recentStatements.get(0).click();
                break;
            default:
                throw new RuntimeException("invalid date!!!");
        }
        BrowserUtilities.wait(3);
    }

    public Integer numOfStatements() {
        return pdfStatements.size();
    }


    public String findFile(String fileName){
        try {
            File folder = new File("/Users/serifekilic/Downloads/");
            File[] files=folder.listFiles();
            assert files != null;
            for (File file : files) {
                if(file.getName().contains(fileName)){
                    return file.getName();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}