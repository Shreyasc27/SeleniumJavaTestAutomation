package com.reddit.automation.ui.pageTests;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCases {

    @Test
    @Parameters({"firstname"})
    public void sampleTest(String firstname, ITestContext context) throws IOException {

        System.out.println("Hurray - " + firstname + " !!!");

    }

}
