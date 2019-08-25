package com.reddit.automation.pageObjects;

import com.reddit.automation.drivers.DriverManager;
import org.openqa.selenium.WebDriver;

public class HomePage{

    private WebDriver driver =null;
    private DriverManager driverManager = null;

    public HomePage(DriverManager driverManager){

        this.driverManager = driverManager;
        this.driver = driverManager.getDriver();

    }

}
