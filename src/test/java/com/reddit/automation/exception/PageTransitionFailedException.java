package com.reddit.automation.ui.exception;

public class PageTransitionFailedException extends Exception{

    public PageTransitionFailedException(String pageName, Throwable throwable) {

        super("Page Transition to " + pageName + " Failed!", throwable);

    }

}
