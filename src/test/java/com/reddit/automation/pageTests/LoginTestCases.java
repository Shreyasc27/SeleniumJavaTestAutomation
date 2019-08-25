package com.reddit.automation.pageTests;

import com.reddit.automation.drivers.DriverManager;
import com.reddit.automation.pageObjects.LoginPage;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.apache.log4j.Logger;

public class LoginTestCases extends BaseTestCase{

    final Logger logger = Logger.getLogger(this.getClass().getName());

    /*@Test
    @Parameters({"firstname"})
    public void sampleTest(String firstname, ITestContext context) throws IOException {

        System.out.println("Hurray - " + firstname + " !!!");
        logger.info("Hurray - " + firstname + " !!!");

    }*/

    @Test
    @Parameters({"username", "password"})
    public void validateLoginInReddit(String username, String password, ITestContext context) throws Exception {

        LoginPage loginPage = new LoginPage(DriverManager.driver);
        loginPage.openReddit();

    }

}
