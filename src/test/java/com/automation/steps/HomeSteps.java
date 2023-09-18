package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user open website")
    public void user_open_website() {
        homePage.openWebsite();
    }

    @Then("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user enters the location {string}")
    public void userEntersTheLocation(String location) {
        homePage.enterLocation(ConfigReader.getProperty(location));
    }

    @And("select check in date {string}")
    public void selectCheckInDate(String checkInDate) {
        homePage.selectCheckInDate(ConfigReader.getProperty(checkInDate));
    }

    @And("select checkout date {string}")
    public void selectCheckoutDate(String checkOutDate) {
        homePage.selectCheckoutDate(ConfigReader.getProperty(checkOutDate));
    }

    @And("select number of guest {string}")
    public void selectNumberOfGuest(String numOfGuest) {
        homePage.selectNumberOfGuest(ConfigReader.getProperty(numOfGuest));
    }

    @And("click on search button")
    public void clickOnSearchButton() {
        homePage.clickOnSearchButton();
    }


}
