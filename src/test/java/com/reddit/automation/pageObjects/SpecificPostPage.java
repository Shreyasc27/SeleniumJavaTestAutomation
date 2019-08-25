package com.reddit.automation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecificPostPage {

    @FindBy(xpath="//div[@class='_1rZYMD_4xY3gRcSS3p8ODO']")
    WebElement voteCount;

    @FindBy(xpath="//button[@data-click-id='upvote']")
    WebElement upVote;

    @FindBy(xpath="//button[@data-click-id='downvote']")
    WebElement downVote;

    private WebDriver driver =null;
    SpecificPostPage specificPostPage = null;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public SpecificPostPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getVoteCount(){

        logger.info("Reading the Vote count.");

        return voteCount.getText();

    }

    public void clickUpVote(){

        logger.info("Up voting the post.");

        upVote.click();

    }

    public void clickDownVote() throws Exception{

        logger.info("Down voting the post.");

        downVote.click();

    }

}
