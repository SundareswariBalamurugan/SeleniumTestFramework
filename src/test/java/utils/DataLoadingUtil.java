package utils;

import DataProviders.ConfigFileReader;

public class DataLoadingUtil {


    ConfigFileReader configFileReader;
    public DataLoadingUtil() {
        this.configFileReader = ConfigFileReader.getInstance();
    }

    /**
     * this method will fetch the values from Configuration.properties file
     */

    public  String fetchConfigValue(String value) {
        String config_Val = null;
        ConfigFileReader.getInstance().setConfig();
        config_Val = ConfigFileReader.getConfigProps().getProperty(value);
        if (config_Val != null)
            return config_Val;
        else
            throw new RuntimeException("values not specified in the Configuration.properties file for this element.");
    }

    /**
     * this method will fetch the locator values from Application.properties file
     */
//    public String fetchLocatorValue(String element) {
//        String locator_Val;
//        ConfigFileReader.getInstance().setConfig();
//        locator_Val = ConfigFileReader.getLocatorProps().getProperty(element);
//        System.out.println("locator value is" +locator_Val);
//        if (locator_Val != null)
//            return locator_Val;
//        else
//            throw new RuntimeException("values not specified in the Configuration.properties file for this element.");
//    }
}
