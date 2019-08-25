package com.reddit.automation.pageObjects;

import com.reddit.automation.drivers.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver =null;
    private DriverManager driverManager = null;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public BasePage(DriverManager driverManager){

        this.driverManager = driverManager;
        this.driver = driverManager.getDriver();

    }

    public void openPage(){

        logger.info("Starting the launch of url.");

        driver.get(System.getenv("URL"));

        logger.info("Launching of the url Done.");

    }

}
