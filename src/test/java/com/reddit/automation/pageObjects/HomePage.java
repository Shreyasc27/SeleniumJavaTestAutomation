package com.reddit.automation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    @FindBy(xpath="//button/span/h1[text()='Home']")
    WebElement textHome;

    private WebDriver driver =null;
    MySubRedditsPage mySubRedditsPage = null;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isHomePageOpened(){

        boolean focusOnHomePage = false;

        if(textHome.isDisplayed()){

            focusOnHomePage = true;

        }

        return focusOnHomePage;

    }

    public MySubRedditsPage openRedditMySubbreddits(){

        logger.info("Starting the launch of SubReddits url.");

        driver.get(driver.getCurrentUrl() + "/subreddits/mine");
        mySubRedditsPage = new MySubRedditsPage(driver);

        logger.info("Launching of the SubReddits url Done.");

        return mySubRedditsPage;

    }


}
