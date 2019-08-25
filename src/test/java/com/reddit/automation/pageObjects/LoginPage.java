package com.reddit.automation.pageObjects;

import com.reddit.automation.constants.CONSTANTS;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage{

    @FindBy(xpath="//a[text()='log in']")
    WebElement linkLogIn;

    WebDriver driver = null;
    HomePage homePage = null;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openReddit(){

        logger.info("Starting the launch of the url.");

        driver.get(CONSTANTS.URL);

        logger.info("Launching of the url Done.");

    }

    public HomePage loginToReddit(String username, String password){

        logger.info("Starting the login to Reddit.com");

        linkLogIn.click();

        List<WebElement> listOfIframes = driver.findElements(By.tagName("iframe"));

        for(int count=0; count<listOfIframes.size(); count++){

            logger.debug("Considering frame number - " + count);

            if(listOfIframes.get(count).getAttribute("src") != null && listOfIframes.get(count).getAttribute("src").contains("login")){

                logger.debug("Frame number that has 'login' in 'src' - " + count);
                driver.switchTo().frame(count);
                driver.findElement(By.id("loginUsername")).sendKeys(username);
                driver.findElement(By.id("loginPassword")).sendKeys(password);
                driver.findElement(By.tagName("button")).click();
                driver.switchTo().defaultContent();
                homePage = new HomePage(driver);
                break;

            }

        }

        logger.info("Login to Reddit.com is Done.");

        return homePage;

    }

}
