package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static Properties properties;
    private static final String CONFIG_PATH = "src/main/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream(CONFIG_PATH);
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Can not load file: config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}