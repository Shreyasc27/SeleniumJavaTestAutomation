package com.reddit.automation.drivers;

import com.reddit.automation.constants.CONSTANTS;
import com.reddit.automation.drivers.configurations.WebBrowser;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    final Logger logger = Logger.getLogger(this.getClass().getName());
    public static WebDriver driver = null;

    public WebDriver createWebDriver(String browser){

        logger.info("[" + browser + "] - [" + WebBrowser.CHROME.toString() + "]");

        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        if(browser.equalsIgnoreCase(WebBrowser.CHROME.toString())){

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Long.parseLong(CONSTANTS.TIMEOUTINSECONDS), TimeUnit.SECONDS);
            driver.manage().window().fullscreen();

        }

        return driver;

    }

    public WebDriver getDriver() {

        return driver;

    }

}
