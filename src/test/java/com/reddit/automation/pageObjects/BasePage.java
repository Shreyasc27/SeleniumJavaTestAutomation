package com.reddit.automation.pageObjects;

import com.reddit.automation.drivers.DriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver =null;
    private DriverManager driverManager = null;

    public BasePage(DriverManager driverManager){

        this.driverManager = driverManager;
        this.driver = driverManager.getDriver();

    }

    public void openPage(){

        driver.get(System.getenv("URL"));

    }

}
