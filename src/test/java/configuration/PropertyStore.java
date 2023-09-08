package configuration;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public enum PropertyStore {
    ENVIRONMENT("environment"),
    BROWSER("browser"),
    BROWSER_WEBELEMENT_TIMEOUT("browser.webelement.timout"),
    BROWSER_IMPLICIT_TIMEOUT("browser.implicit.timeout"),
    BROWSER_ATTACH_SCREENSHOT("browser.attachscreenshot"),
    BROWSER_HEADLESS("browser.headless");

    private String propertyValue;
    private String propertyKey;
    public static final String CONFIG_PROPERTIES = "config.properties";
    public static Properties properties = null;

    PropertyStore(String key) {
        this.propertyKey = key;
        this.propertyValue = this.retrieveValue(key);
    }

    private String retrieveValue(String key) {
        return System.getProperty(key) != null ? System.getProperty(key) : getValueFromConfigFile(key);
    }

    private String getValueFromConfigFile(String key) {
        if (properties == null) {
            properties = loadConfigFile();
        }
        Object objFile = properties.get(key);
        return objFile != null ? Objects.toString(objFile) : null;
    }

    private Properties loadConfigFile() {
        Properties copy = null;
        try {
            InputStream confFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
            try {
                Properties properties = new Properties();
                properties.load(confFileStream);
                copy = properties;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (confFileStream != null) {
                    try {
                        confFileStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }

    public boolean isSpecified() {
        return StringUtils.isNotEmpty(this.propertyValue);
    }

    public int getIntValue() {
        return Integer.parseInt(this.retrieveValue(this.propertyKey));
    }

    public boolean getBoolean() {
        return this.isSpecified() && Boolean.parseBoolean(this.propertyValue);
    }

    public String getPropertyValue() {
        return this.retrieveValue(this.propertyKey);
    }
}
