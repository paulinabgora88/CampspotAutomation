package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class BasePage {

    WebDriver driver = DriverUtils.getDriver();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public static String getMonthAndYearFromDate(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(ConfigReader.getProperty("date.format"));
        LocalDate localDate = LocalDate.parse(date, dateFormatter);
        return StringUtils.capitalize(localDate.getMonth().toString().toLowerCase()) + " " + localDate.getYear();
    }

    public boolean isPresent(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public int getDayFromDate(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(ConfigReader.getProperty("date.format"));
        LocalDate localDate = LocalDate.parse(date, dateFormatter);
        return localDate.getDayOfMonth();
    }

}
