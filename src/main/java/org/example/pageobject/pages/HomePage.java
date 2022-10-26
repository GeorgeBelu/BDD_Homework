package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.pageobject.utils.TypesOfData.*;

public class HomePage extends BasePage
{
    @FindBy(id = "nav-global-location-popover-link")
    protected WebElement deliverField;

    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public HomePage openPage()
    {
        webDriver.get("https://www.amazon.com/");

        String wrongPageID = "//a[@id='nav-bb-logo']";
        if (!webDriver.findElements(By.xpath(wrongPageID)).isEmpty())
        {
            webDriver.navigate().refresh();
        }
        return this;
    }

    public void clickOnDeliverTo()
    {
        deliverField.click();
    }

    public void applyZipCode(String zipCode)
    {
       enterZipCode(zipCode);

        WebElement applyZipCodePopUpButton = getElementBy(XPATH, "//div[@class='a-popover-footer']/span", 10);
        applyZipCodePopUpButton.click();

        webDriver.navigate().refresh();

    }
    public String invalidZipCodeErrorMessage()
    {
        WebElement errorMessage = getElementBy(ID,"GLUXZipError", 10);
        return errorMessage.getText();
    }
    public void enterZipCode(String zipCode)
    {
        WebElement zipCodeField = getElementBy(ID, "GLUXZipUpdateInput", 10);
        zipCodeField.sendKeys(zipCode);

        WebElement applyButton = getElementBy(XPATH, "//div[@class='a-column a-span4 a-span-last']", 10);
        applyButton.click();
    }
    public String zipCodeAddressUpdated()
    {
        WebElement deliverFieldUpdated = getElementBy(ID, "glow-ingress-line2", 10);

        return deliverFieldUpdated.getText().replaceAll("\\D", "");
    }
    public boolean isRegionPresent(String country)
    {
        clickOnDeliverTo();
        selectDropDownList();
        try
        {
            webDriver.findElement(By.xpath("//a[text()='"+ country +"']"));
        } catch (NoSuchElementException e)
        {
            return false;
        }
        return true;
    }
    private void selectDropDownList()
    {
        WebElement dropDownButton = getElementBy(ID, "GLUXCountryListDropdown", 10);
        dropDownButton.click();
    }

}
