package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    static Properties properties;

    /**
     * This function initializes the test settings from the default properties file
     * with the name "testsettings.properties" present in the current working
     * directory
     * 
     * @throws IOExceptioni
     */
    public static void initializeProperties() throws IOException {
        properties = new Properties();
        InputStream fileStream = PropertiesManager.class.getResourceAsStream("/testsettings.properties");
        properties.load(fileStream);
        fileStream.close();
    }

    /**
     * This function is used to get the value of a particular test setting
     * 
     * @param propertyName - The name of the property/key/setting
     * @return
     */
    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName, "Not Found");
    }

    /**
     * This function sets the value of a property at runtime
     * 
     * @param propertyName  - The name of the property/key/setting
     * @param propertyValue - The value of the property
     */
    public static void setProperty(String propertyName, String propertyValue) {
        properties.setProperty(propertyName, propertyValue);
    }

    /**
     * Gets the number of properties
     * 
     * @return
     */
    public static int getPropertiesCount() {
        return properties.size();
    }
}
