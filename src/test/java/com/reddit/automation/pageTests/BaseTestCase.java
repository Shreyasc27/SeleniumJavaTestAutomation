package com.reddit.automation.pageTests;

import com.reddit.automation.config.EnvironmentConfiguration;
import com.reddit.automation.constants.CONSTANTS;
import com.reddit.automation.drivers.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTestCase {

    Logger logger = Logger.getLogger(this.getClass().getName());
    EnvironmentConfiguration environmentConfiguration = null;
    WebDriver driver = null;
    DriverManager driverManager = null;

    @BeforeSuite(alwaysRun = true)
    public void setUpConfigurationProperties(){

        logger.info("Starting set up of configuration properties.");

        environmentConfiguration = new EnvironmentConfiguration();
        environmentConfiguration.setProjectConfiguration("./src/test/resources/properties/reddit.properties");

        environmentConfiguration.setLoggerConfiguration("./src/test/resources/properties/log4j.properties");

        logger.info("URL - " + System.getProperty("URL"));
        logger.info("BROWSER - " + System.getProperty("BROWSER"));

        logger.info("Ending set up of configuration properties.");

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpWebDriver(){

        logger.info("Starting set up of web driver.");

        String browserForExecution = CONSTANTS.BROWSER;
        driverManager = new DriverManager();
        driverManager.createWebDriver(browserForExecution);

        logger.info("Ending set up of web driver.");

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {

        logger.info("Starting close of browser.");

        driverManager.getDriver().quit();

        logger.info("Ending close of browser.");

    }

}
