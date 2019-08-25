package com.reddit.automation.pageObjects;

import com.reddit.automation.constants.CONSTANTS;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPage{

    WebDriver driver = null;
    HomePage homePage = null;
    final Logger logger = Logger.getLogger(this.getClass().getName());

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public void openReddit() throws Exception{

        driver.get(CONSTANTS.URL);
        Thread.sleep(10000);

    }

}
