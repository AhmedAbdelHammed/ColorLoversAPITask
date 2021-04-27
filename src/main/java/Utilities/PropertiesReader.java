package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method to get the base URL from the properties config
    public String getBaseURL(){
        return properties.getProperty("baseURL");
    }

    //Method to get the patterns end point from the properties config
    public String getPatternsEndPointURL(){
        return properties.getProperty("patternsEndPoint");
    }
}
