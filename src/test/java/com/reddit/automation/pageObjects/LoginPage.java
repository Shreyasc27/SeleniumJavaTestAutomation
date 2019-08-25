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
    final Logger logger = Logger.getLogger(this.getClass().getName());

    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openReddit() throws Exception{

        driver.get(CONSTANTS.URL);

    }

    public HomePage loginToReddit(String username, String password) throws Exception{

        linkLogIn.click();

        List<WebElement> listOfIframes = driver.findElements(By.tagName("iframe"));

        for(int count=0; count<listOfIframes.size(); count++){

            logger.info("Considering frame number - " + count);

            if(listOfIframes.get(count).getAttribute("src") != null && listOfIframes.get(count).getAttribute("src").contains("login")){

                logger.info("Frame number that has 'login' in 'src' - " + count);
                driver.switchTo().frame(count);
                driver.findElement(By.id("loginUsername")).sendKeys(username);
                driver.findElement(By.id("loginPassword")).sendKeys(password);
                driver.findElement(By.tagName("button")).click();
                homePage = new HomePage(driver);
                break;

            }

        }

        return homePage;

    }

}
