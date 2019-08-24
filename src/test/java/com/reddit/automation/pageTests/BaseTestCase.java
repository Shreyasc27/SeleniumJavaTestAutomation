package com.reddit.automation.pageTests;

import com.reddit.automation.config.EnvironmentConfiguration;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class BaseTestCase {

    final Logger logger = Logger.getLogger(this.getClass().getName());
    EnvironmentConfiguration environmentConfiguration = null;

    @BeforeSuite(alwaysRun = true)
    public void setUpConfigurationProperties(){

        environmentConfiguration = new EnvironmentConfiguration();
        environmentConfiguration.readConfiguration(System.getProperty("user.dir") + "/src/test/resources/properties/reddit.properties");

        logger.info("URL - " + System.getProperty("URL"));
        logger.info("BROWSER - " + System.getProperty("BROWSER"));

    }

}
