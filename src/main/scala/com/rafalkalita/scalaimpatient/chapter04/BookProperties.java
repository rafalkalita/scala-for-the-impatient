package com.rafalkalita.scalaimpatient.chapter04;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BookProperties {

    public static Map<String, String> getAsMap() {
        Map<String, String> propStringMap = new HashMap<>();
        BookProperties instance = new BookProperties();

        Properties properties = instance.loadProperties("test.properties");

        for (final String name : properties.stringPropertyNames()) {
            propStringMap.put(name, properties.getProperty(name));
        }

        return propStringMap;
    }

    public static Properties get() {
        BookProperties instance = new BookProperties();
        return instance.loadProperties("test.properties");
    }

    private Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (stream != null) {
            try {
                properties.load(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
