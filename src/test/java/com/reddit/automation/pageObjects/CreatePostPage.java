package com.reddit.automation.pageObjects;

import com.reddit.automation.drivers.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreatePostPage {

    @FindBy(xpath="//button[@aria-label='Create Post']")
    WebElement createPost;

    @FindBy(xpath="//div/textarea")
    WebElement postTitle;

    @FindBy(xpath="//button")
    List<WebElement> listOfButton;

    Logger logger = Logger.getLogger(this.getClass().getName());
    private WebDriver driver = null;
    SpecificPostPage specificPostPage = null;

    public CreatePostPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public SpecificPostPage createPost(String postToBeCreated){

        logger.info("Creation of post started.");

        specificPostPage = new SpecificPostPage(DriverManager.driver);

        createPost.click();
        postTitle.sendKeys(postToBeCreated);

        for(int count=0; count<listOfButton.size(); count++){

            logger.debug(count + ") " + listOfButton.get(count).getText());

            if(listOfButton.get(count).getText().trim().equals("POST")){

                listOfButton.get(count).click();
                break;

            }

        }

        logger.info("Creation of post ended.");

        return specificPostPage;

    }

}
