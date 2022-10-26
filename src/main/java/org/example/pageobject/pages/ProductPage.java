package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.example.pageobject.modules.ProductManipulation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pageobject.utils.TypesOfData.XPATH;

public class ProductPage extends BasePage
{

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductManipulation selectBrand() {
        WebElement brandSelection = getElementBy(XPATH, "//span[text()='Featured Brands']/../following-sibling::ul/li[1]//a", 15);
        brandSelection.click();

        return new ProductManipulation(webDriver);
    }

    public ProductManipulation priceRange() {
        WebElement priceRange = getElementBy(XPATH, "//span[text()='Price']/..//following-sibling::ul/li[2]//a", 15);
        priceRange.click();

        return new ProductManipulation(webDriver);
    }

    public ProductManipulation selectFirstItemInList()
    {
        WebElement firstElement = getElementBy(XPATH,"//div[@class='a-section a-spacing-medium " +
                "_octopus-search-result-card_style_apbSearchResultsContainer__bCqjb']/div[1]",10);
        firstElement.click();

        return new ProductManipulation(webDriver);
    }
}
