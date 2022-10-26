package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pageobject.utils.TypesOfData.XPATH;

public class SignInPage extends BasePage
{
    public SignInPage(WebDriver webDriver)
    {
        super(webDriver);
    }
    public String signInLabel()
    {
        WebElement signInLabel = getElementBy(XPATH,"//*[contains(text(),'Sign in')]",10);
        return signInLabel.getText();
    }
}
