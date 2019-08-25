package com.reddit.automation.pageTests;

import com.reddit.automation.drivers.DriverManager;
import com.reddit.automation.pageObjects.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class E2ETestCases extends BaseTestCase {

    final Logger logger = Logger.getLogger(this.getClass().getName());

    /*@Test
    @Parameters({"firstname"})
    public void sampleTest(String firstname, ITestContext context) throws IOException {

        System.out.println("Hurray - " + firstname + " !!!");
        logger.info("Hurray - " + firstname + " !!!");

    }*/

    @Test
    @Parameters({"username", "password"})
    public void validateLoginInReddit(String username, String password, ITestContext context){

        LoginPage loginPage = new LoginPage(DriverManager.driver);
        loginPage.openReddit();
        HomePage homePage = loginPage.loginToReddit(username, password);
        Assert.assertTrue(homePage.isHomePageOpened(), "Error in login to Reddit.com. Home Page is not displayed.");

    }

    @Test
    @Parameters({"username", "password", "listOfSubReddits"})
    public void validateListOfMySubReddits(String username, String password, String listOfSubReddits, ITestContext context) {

        LoginPage loginPage = new LoginPage(DriverManager.driver);
        loginPage.openReddit();
        HomePage homePage = loginPage.loginToReddit(username, password);
        Assert.assertTrue(homePage.isHomePageOpened(), "Error in login to Reddit.com. HomePage is not displayed.");
        MySubRedditsPage mySubRedditsPage = homePage.openRedditMySubbreddits();
        Assert.assertTrue(mySubRedditsPage.isMySubbRedditsPageOpened(), "Error in navigating to MySubReddits Page. SubReddits Page is not displayed.");
        Assert.assertTrue(mySubRedditsPage.validateTheListOfSubReddits(listOfSubReddits), "List of MySubReddits do not match.");

    }

    @Test
    @Parameters({"username", "password", "mySubRedditToBeViewed"})
    public void viewOneOfMySubReddits(String username, String password, String mySubRedditToBeViewed, ITestContext context) {

        LoginPage loginPage = new LoginPage(DriverManager.driver);
        loginPage.openReddit();
        HomePage homePage = loginPage.loginToReddit(username, password);
        Assert.assertTrue(homePage.isHomePageOpened(), "Error in login to Reddit.com. HomePage is not displayed.");
        MySubRedditsPage mySubRedditsPage = homePage.openRedditMySubbreddits();
        Assert.assertTrue(mySubRedditsPage.isMySubbRedditsPageOpened(), "Error in navigating to MySubReddits Page. SubReddits Page is not displayed.");
        mySubRedditsPage.clickSpecificMySubReddit(mySubRedditToBeViewed);
        Assert.assertTrue(mySubRedditsPage.navigateValidationToSpecificMySubReddit(mySubRedditToBeViewed), "Error in navigating to the specific SubReddits Page.");


    }

    @Test
    @Parameters({"username", "password", "mySubRedditToBeViewed", "expectedVoteCount"})
    public void createPostAndVerifyUpvote(String username, String password, String mySubRedditToBeViewed, String expectedVoteCount, ITestContext context) throws Exception{

        LoginPage loginPage = new LoginPage(DriverManager.driver);
        loginPage.openReddit();
        HomePage homePage = loginPage.loginToReddit(username, password);
        Assert.assertTrue(homePage.isHomePageOpened(), "Error in login to Reddit.com. HomePage is not displayed.");
        MySubRedditsPage mySubRedditsPage = homePage.openRedditMySubbreddits();
        Assert.assertTrue(mySubRedditsPage.isMySubbRedditsPageOpened(), "Error in navigating to MySubReddits Page. SubReddits Page is not displayed.");
        mySubRedditsPage.clickSpecificMySubReddit(mySubRedditToBeViewed);
        CreatePostPage createPostPage = new CreatePostPage(DriverManager.driver);
        SpecificPostPage specificPostPage = createPostPage.createPost();
        String voteCount = null;
        specificPostPage.clickUpVote();
        voteCount = specificPostPage.getVoteCount();
        Assert.assertEquals(voteCount, expectedVoteCount, "Error in Up Voting.");

    }

    @Test
    @Parameters({"username", "password", "mySubRedditToBeViewed", "expectedVoteCount"})
    public void createPostAndVerifyDownvote(String username, String password, String mySubRedditToBeViewed, String expectedVoteCount, ITestContext context) throws Exception{

        LoginPage loginPage = new LoginPage(DriverManager.driver);
        loginPage.openReddit();
        HomePage homePage = loginPage.loginToReddit(username, password);
        Assert.assertTrue(homePage.isHomePageOpened(), "Error in login to Reddit.com. HomePage is not displayed.");
        MySubRedditsPage mySubRedditsPage = homePage.openRedditMySubbreddits();
        Assert.assertTrue(mySubRedditsPage.isMySubbRedditsPageOpened(), "Error in navigating to MySubReddits Page. SubReddits Page is not displayed.");
        mySubRedditsPage.clickSpecificMySubReddit(mySubRedditToBeViewed);
        CreatePostPage createPostPage = new CreatePostPage(DriverManager.driver);
        SpecificPostPage specificPostPage = createPostPage.createPost();
        String voteCount = null;
        specificPostPage.clickDownVote();
        voteCount = specificPostPage.getVoteCount();
        Assert.assertEquals(voteCount, expectedVoteCount, "Error in Down Voting.");

    }

}