package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CampListingPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class,' app-search-results-list')]/li/a")
    WebElement searchResultLink;

    @FindBy(xpath = "//ul[contains(@class,' app-search-results-list')]/li/a")
    List<WebElement> searchResultLinks;

    public boolean isSearchCampListDisplayed() {
        waitForElementToBeVisible(searchResultLink);
        return searchResultLinks.size() > 0;
    }

}
