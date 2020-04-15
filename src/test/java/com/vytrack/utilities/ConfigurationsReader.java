package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationsReader {
    private static Properties configFile;

    static {
        try {
            /**
             * Provide access to our properties file.
             * Execute 1 time when class loaded by JVM
             */
            FileInputStream fileInputStream = new FileInputStream("configurations.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get property depends on key
     *
     * @param key
     * @return Value of property
     */
    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }

}
