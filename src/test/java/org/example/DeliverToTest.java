package org.example;

import org.example.pageobject.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.pageobject.utils.TypesOfData.COUNTRY;
import static org.example.pageobject.utils.TypesOfData.ZIP_CODE;

public class DeliverToTest extends BaseTestModel
{
    @Test
    public void regionSelectionZipCode()
    {
        HomePage homePage = new HomePage(webDriver);
        String zipCodeAfterUpdate = homePage
                .openPage()
                .applyZipCode(ZIP_CODE)
                .zipCodeAddressUpdated();

        Assert.assertEquals(zipCodeAfterUpdate, ZIP_CODE, "Zip Codes do not match.");
    }
    @Test
    public void countryIsPresentInList()
    {
        HomePage homePage = new HomePage(webDriver);
        String countryName = homePage
                .openPage()
                .isRegionPresent();

        Assert.assertEquals(countryName, COUNTRY, COUNTRY + "is not present in the list.");
    }
    @Test(dependsOnMethods = "countryIsPresentInList")
    public void addressUpdatedWhenPurchasing()
    {
        HomePage homePage = new HomePage(webDriver);
        boolean isAddressUpdated = homePage
                .openPage()
                .startPage()
                .openCategory()
                .selectFirstItemInList()
                .deliveryAddressUpdated();

        Assert.assertTrue(isAddressUpdated,"Region did not get updated in the item delivery location.");
    }
    @Test
    public void signInRedirectFunctionality()
    {
        HomePage homePage = new HomePage(webDriver);
        String signInPageLabel = homePage
                .openPage()
                .signIn()
                .signInLabel();

        Assert.assertEquals(signInPageLabel, "Sign in", "The page you got redirected to or the message is incorrect");
    }
}
