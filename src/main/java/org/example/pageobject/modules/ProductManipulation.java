package org.example.pageobject.modules;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pageobject.utils.TypesOfData.COUNTRY;
import static org.example.pageobject.utils.TypesOfData.XPATH;

public class ProductManipulation extends BasePage
{

    public ProductManipulation(WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean deliveryAddressUpdated()
    {
        WebElement regionSelect = getElementBy(XPATH,"//div[@id='contextualIngressPtLabel_deliveryShortLine']/span[2]",
                10);
        return COUNTRY.equals(regionSelect.getText());
    }
}
