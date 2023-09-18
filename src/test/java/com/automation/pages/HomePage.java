package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    final String XPATH_CHECK_IN_MONTH_YEAR = "//h3[contains(text(),'%s')]";
    final String XPATH_CHECK_IN_DATE = "//h3[contains(text(),'%s')]/following-sibling::table//td/button[normalize-space()='%s']";
    final String XPATH_GUEST_INCREASE_BTN = "//*[contains(@class,'menu-category-label') and contains(text(), '%s')]/ancestor::tr//button[contains(@class,'mod-increase')]";

    @FindBy(name = "search-location")
    WebElement searchLocationInput;

    @FindBy(xpath = "//button[@aria-label='Next Month']")
    WebElement nextCalendarMonthBtn;

    @FindBy(xpath = "//button[@aria-label='Check In Date: Add Dates']")
    WebElement checkInDateBtn;

    @FindBy(xpath = "//button[@aria-label='Check Out Date: Add Dates']")
    WebElement checkOutDateBtn;

    @FindBy(xpath = "//ul[@class='location-search-results app-location-search-results']/li")
    WebElement locationSuggestionDropdown;

    @FindBy(xpath = "//button[@class='guests-picker-input']")
    WebElement guestPickerInput;

    @FindBy(xpath = "//div[contains(@class,'menu-category-label') and contains(text(), 'Adults')]/ancestor::tr//button[contains(@class,'mod-decrease')]")
    WebElement adultDecreaseBtn;

    @FindBy(xpath = "//button[contains(@class,'app-search-button')]")
    WebElement searchBtn;

    @FindBy(xpath = "//a[contains(@class,'list-your-property')]")
    WebElement listYourPropertyTab;




    public void openWebsite() {
        driver.get(ConfigReader.getProperty("application.url"));
    }

    public boolean isHomePageDisplayed(){
        waitForElementToBeVisible(searchLocationInput);
        waitForElementToBeVisible(listYourPropertyTab);
        return searchLocationInput.isDisplayed() && listYourPropertyTab.isDisplayed();
    }

    public void selectCheckInDate(String checkInDate) {
        checkInDateBtn.click();
        String monthAndYear = getMonthAndYearFromDate(checkInDate);
        String monthAndYearLoc = String.format(XPATH_CHECK_IN_MONTH_YEAR, monthAndYear);
        while (!isPresent(By.xpath(monthAndYearLoc))) {
            nextCalendarMonthBtn.click();
        }

        int day = getDayFromDate(checkInDate);
        String dateLoc = String.format(XPATH_CHECK_IN_DATE, monthAndYear, String.valueOf(day));
        driver.findElement(By.xpath(dateLoc)).click();
    }

    public void selectCheckoutDate(String checkOutDate) {
        checkOutDateBtn.click();
        String monthAndYear = getMonthAndYearFromDate(checkOutDate);
        String monthAndYearLoc = String.format(XPATH_CHECK_IN_MONTH_YEAR, monthAndYear);
        while (!isPresent(By.xpath(monthAndYearLoc))) {
            nextCalendarMonthBtn.click();
        }

        int day = getDayFromDate(checkOutDate);
        String dateLoc = String.format(XPATH_CHECK_IN_DATE, monthAndYear, String.valueOf(day));
        driver.findElement(By.xpath(dateLoc)).click();
    }


    public void enterLocation(String location) {
        searchLocationInput.sendKeys(location);
        waitForElementToBeVisible(locationSuggestionDropdown);
        locationSuggestionDropdown.click();
    }

    public void selectNumberOfGuest(String numOfGuest) {
        guestPickerInput.click();

        // Resetting adult to zero
        adultDecreaseBtn.click();
        adultDecreaseBtn.click();

        String options[] = numOfGuest.split(",");
        for(String option : options){
            selectGuest(option.trim());
        }
        guestPickerInput.click();
    }

    public void selectGuest(String option){
        int numOfGuest = Integer.parseInt(option.split(" ")[0].trim());
        String guestName = option.split(" ")[1].trim();

        String loc = String.format(XPATH_GUEST_INCREASE_BTN, guestName);
        for(int i=1; i<=numOfGuest; i++){
            driver.findElement(By.xpath(loc)).click();
        }
    }

    public void clickOnSearchButton() {
        searchBtn.click();
    }
}
