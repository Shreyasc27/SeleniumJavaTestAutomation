package com.reddit.automation.pageTests;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import org.apache.log4j.Logger;

public class LoginTestCases extends BaseTestCase{

    final Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    @Parameters({"firstname"})
    public void sampleTest(String firstname, ITestContext context) throws IOException {

        logger.info("Hurray - " + firstname + " !!!");


    }

}
