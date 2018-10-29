package com.translator.dictionary;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Komyshenets on 11/17/2017.
 */
public class ConfigFactory {
    private static final Logger log = Logger.getLogger(ConfigFactory.class);
    private static final String CONFIG_PROPERTY = "configClasses.properties";

    /**
     * Class for generate collection of interfase realisations described in config files
     */
    public static <T extends Config> List<T> getConfigsForInterface(Class<T> configTypeClass, String lang) {
        ArrayList<T> ts = new ArrayList<>();
        try {
            Properties properties = new Properties();
            properties.load(ConfigFactory.class.getResourceAsStream(CONFIG_PROPERTY));

            String commonConfigs = configTypeClass.getSimpleName();

            ts.addAll(getValues(properties.getProperty(commonConfigs)));
            if (lang != null) {
                String concretLangConfigs = commonConfigs + "." + lang;
                ts.addAll(getValues(concretLangConfigs));
                Collections.reverse(ts);
            }
            return ts;

        } catch (Exception e) {
            log.warn(String.format("Can't load configs property: %s", CONFIG_PROPERTY), e);
            return new ArrayList<>();
        }
    }

    /**
     * @param configs config classes "space" splited
     */
    private static <T> Collection<T> getValues(String configs) {
        ArrayList<T> result = new ArrayList<>();

        if (configs != null) {
            for (String aClass : configs.split(" ")) {
                try {
                    Object newInstanceConfig = Class.forName(aClass.trim()).getDeclaredConstructor().newInstance();
                    result.add((T) newInstanceConfig);
                } catch (Throwable e) {
                    log.warn(String.format("Can't createAndFill instance %s", aClass.trim()), e);
                }
            }
        }
        return result;
    }
}