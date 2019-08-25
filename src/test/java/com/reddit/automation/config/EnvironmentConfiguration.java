package com.reddit.automation.config;

import com.reddit.automation.constants.CONSTANTS;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfiguration {

    final Logger logger = Logger.getLogger(this.getClass().getName());

    public void setProjectConfiguration(String configurationFilePath) {

        try{

            InputStream input = new FileInputStream(configurationFilePath);

            Properties prop = new Properties();
            prop.load(input);

            CONSTANTS.URL = prop.getProperty("URL");
            CONSTANTS.BROWSER = prop.getProperty("BROWSER");
            CONSTANTS.TIMEOUTINSECONDS = prop.getProperty("TIMEOUTINSECONDS");

            logger.info("URL - " + CONSTANTS.URL);
            logger.info("BROWSER - " + CONSTANTS.BROWSER);

        }catch(IOException ex) {

            logger.error("Error in reading the contents of " + configurationFilePath + ".", ex);

        }

    }

    public void setLoggerConfiguration(String configurationFilePath) {

        PropertyConfigurator.configure(configurationFilePath);

    }

}

