package com.reddit.automation.exception;

public class PageTransitionFailedException extends Exception{

    public PageTransitionFailedException(String pageName, Throwable throwable) {

        super("Page Transition to " + pageName + " Failed!", throwable);

    }

}
