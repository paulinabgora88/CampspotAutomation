package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {

    static WebDriver driver;

    public static void createDriver() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Wait for each command to get success response till 60 sec maximum
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
