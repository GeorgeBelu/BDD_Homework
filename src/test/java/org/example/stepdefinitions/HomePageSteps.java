package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.HomePage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.stepdefinitions.BaseSteps.webDriver;

public class HomePageSteps
{
    @Given("User is on {string}")
    public void userIsOn(String pageName)
    {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        PAGES_STORAGE.put(pageName, homePage);
    }

    @When("User clicks on the Deliver To button in the {string}")
    public void userClicksOnTheButtonInThe(String pageName)
    {
        ((HomePage) PAGES_STORAGE.get(pageName)).clickOnDeliverTo();
    }

    @Then("User can enter and apply the zip code {string} and continue to {string}")
    public void userCanEnterAndApplyTheZipCodeAsAndContinueTo(String zipCode, String pageName)
    {
        ((HomePage) PAGES_STORAGE.get(pageName)).applyZipCode(zipCode);
    }


    @And("{string} will be updated in the Delivery field in the {string}")
    public void willBeUpdatedInTheDeliveryFieldInThe(String zipCode, String pageName)
    {
        HomePage homepage = (HomePage) PAGES_STORAGE.get(pageName);
        String addressUpdated = homepage.zipCodeAddressUpdated();
        Assert.assertEquals(zipCode, addressUpdated, "Zip Codes do not match.");
    }

    @Then("User is able to find the {string} in the drop down list")
    public void userIsAbleToFindTheInTheDropDownList(String country)
    {
        HomePage homePage = new HomePage(webDriver);
        boolean isCountryPresentInList = homePage
                .openPage()
                .isRegionPresent(country);
        Assert.assertTrue(isCountryPresentInList, country + " is not present in the list.");
    }

    @Then("User can enter and apply an invalid zip code {string}")
    public void userCanEnterAndApplyTheWrongZipCodeAs(String zipCode)
    {
        ((HomePage) PAGES_STORAGE.get("Home Page")).enterZipCode(zipCode);
    }

    @And("User will be notified with {string} error message")
    public void userWillBeNotifiedWithErrorMessage(String expectedErrorMessage)
    {
        String errorMessage = ((HomePage) PAGES_STORAGE.get("Home Page")).invalidZipCodeErrorMessage();
        Assert.assertEquals(errorMessage,expectedErrorMessage, "The Zip Code is valid");
    }
}
