package com.reddit.automation.config;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfiguration {

    final Logger logger = Logger.getLogger(this.getClass().getName());

    public void readConfiguration(String configurationFilePath) {

        try{

            InputStream input = new FileInputStream(configurationFilePath);

            Properties prop = new Properties();
            prop.load(input);

            System.setProperty("URL", prop.getProperty("URL"));
            System.setProperty("BROWSER", prop.getProperty("BROWSER"));

        }catch(IOException ex) {

            logger.error("Error in reading the contents of " + configurationFilePath + ".", ex);

        }

    }

}

