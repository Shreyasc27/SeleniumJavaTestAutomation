package com.reddit.automation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySubRedditsPage {

    @FindBy(xpath="//li[@class='selected']/a[text()='my subreddits']")
    WebElement mySubRedditsTab;

    @FindBy(xpath="//p[@class='titlerow']/a[@class='title']")
    List<WebElement> listOfMySubRedditsTab;

    @FindBy(xpath="//p[@class='titlerow']")
    WebElement specificMySubRedditsTab;

    Logger logger = Logger.getLogger(this.getClass().getName());
    private WebDriver driver =null;

    public MySubRedditsPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isMySubbRedditsPageOpened(){

        boolean focusMySubbRedditsPage = false;

        if(mySubRedditsTab.isDisplayed()){

            focusMySubbRedditsPage = true;

        }

        return focusMySubbRedditsPage;

    }

    public boolean validateTheListOfSubReddits(String listOfMySubReddits){

        logger.info("Validating the list of Sub Reddits.");

        boolean listOfMySubRedditsMatches = false;

        ArrayList<String> listOfExpectedMySubReddits = getListOfExpectedMySubReddits(listOfMySubReddits);
        ArrayList<String> listOfActualMySubReddits = getListOfActualMySubReddits();

        List<Boolean> listOfMySubRedditsMatchStatus = new ArrayList<>();

        if(listOfActualMySubReddits.size() == listOfExpectedMySubReddits.size()){

            logger.info("Number of expected and actual MySubReddits match.");

            for(int count=0; count<listOfExpectedMySubReddits.size(); count++){

                if(listOfActualMySubReddits.contains(listOfExpectedMySubReddits.get(count))){

                    listOfMySubRedditsMatchStatus.add(true);

                }else{

                    listOfMySubRedditsMatchStatus.add(false);

                }

            }

            if(!listOfMySubRedditsMatchStatus.contains(false)){

                logger.info("Names of expected and actual MySubReddits match.");
                listOfMySubRedditsMatches = true;

            }

        }

        logger.info("Validating the list of Sub Reddits Done.");

        return listOfMySubRedditsMatches;


    }

    public ArrayList<String> getListOfExpectedMySubReddits(String listOfMySubReddits){

        logger.info("Expected list of MySubReddits - " + listOfMySubReddits);

        List<String> listOfExpectedMySubReddits = new ArrayList<>();

        listOfExpectedMySubReddits = Arrays.asList(listOfMySubReddits.split("\\|"));

        for(int i=0; i<listOfExpectedMySubReddits.size(); i++){

            logger.info(i + ") " + listOfExpectedMySubReddits.get(i));

        }

        ArrayList<String> arrayListOfExpectedMySubReddits = new ArrayList<String>(listOfExpectedMySubReddits);

        logger.info(arrayListOfExpectedMySubReddits.size() + " list of expected MySubReddits.");

        return arrayListOfExpectedMySubReddits;

    }

    public ArrayList<String> getListOfActualMySubReddits(){

        ArrayList<String> listOfActualMySubReddits = new ArrayList<>();

        logger.info(listOfMySubRedditsTab.size() + " list of actual MySubReddits - ");

        for(int count=0; count<listOfMySubRedditsTab.size(); count++){

            listOfActualMySubReddits.add(listOfMySubRedditsTab.get(count).getText());
            logger.info(count + ") " + listOfMySubRedditsTab.get(count).getText());

        }

        return listOfActualMySubReddits;

    }

    public void clickSpecificMySubReddit(String mySubRedditToBeViewed){

        logger.info("Clicking on the specific SubReddit.");

        WebElement specificMySubRedditToBeClicked = specificMySubRedditsTab.findElement(By.xpath("//a[contains(text(),'" + mySubRedditToBeViewed + "')]"));
        specificMySubRedditToBeClicked.click();

        logger.info("Clicking on the specific SubReddit Done.");

    }

    public boolean navigateValidationToSpecificMySubReddit(String mySubRedditToBeViewed){

        logger.info("Validating if the SubReddit url has been invoked.");

        boolean navigationToSpecificSubRedditSuccess = false;

        if(driver.getCurrentUrl().contains(mySubRedditToBeViewed)){

            navigationToSpecificSubRedditSuccess = true;

        }

        logger.info("Validating if the SubReddit url has been invoked Done.");

        return navigationToSpecificSubRedditSuccess;

    }

}
