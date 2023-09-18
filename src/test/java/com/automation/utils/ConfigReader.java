package com.automation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static void initProperties() {
        try {
            prop = new Properties();
            prop.load(new FileReader("src/test/resources/config/config.properties"));
        } catch (Exception e) {

        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
