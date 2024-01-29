package DataProviders;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {



    @Getter
    static Properties configProps;
    @Getter
    static Properties locatorProps;
    private static ConfigFileReader configFileReader;

    private ConfigFileReader(){

    }

    private static final String CONFIG_PROPS = "src/test/java/configuration/Config.properties";
    private static final String LOCATOR_PROPS = "src/test/java/configuration/Locators.properties";


    public static ConfigFileReader getInstance() {
        if (configFileReader == null) {
            configFileReader = new ConfigFileReader();
        }
        return configFileReader;
    }

    public static void setConfig(){
        setConfigProps(readConfigFileValues(CONFIG_PROPS));
        setLocatorProps(readConfigFileValues(LOCATOR_PROPS));
    }

    public static void setConfigProps(Properties configProps) {
        ConfigFileReader.configProps = configProps;
    }

    public static void setLocatorProps(Properties locatorProps) {
        ConfigFileReader.locatorProps = locatorProps;
    }




    /**
     * this method will read the values from properties file
     */

    public static Properties readConfigFileValues(String fileName){
        Properties props = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            try {
                props.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + props);
        }
        return props;
    }
}
