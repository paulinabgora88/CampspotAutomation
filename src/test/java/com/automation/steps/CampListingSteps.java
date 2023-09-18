package com.automation.steps;

import com.automation.pages.CampListingPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CampListingSteps {

    CampListingPage campListingPage = new CampListingPage();

    @Then("verify user is on camp listing page")
    public void verifyUserIsOnCampListingPage() {
        Assert.assertTrue(campListingPage.isSearchCampListDisplayed());
    }
}
