package bibit.framework.config;

import java.io.InputStream;
import java.util.Properties;

/** Config reader class for loading application properties. */
public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    /** Load application properties from the specified environment file. */
    private static void loadProperties() {

        String env = System.getProperty("env", "staging");

        String file = "config/" + env + ".properties";

        try {

            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(file);

            if (input == null) {

                throw new RuntimeException("Config file not found: " + file);
            }

            properties.load(input);

        } catch (Exception e) {

            throw new RuntimeException("Failed load config", e);
        }
    }

    /** Get the value of a property from the config file. */
    /**
     * @param key Property key
     */
    /**
     * @return Property value or null if not found.
     */
    public static String get(String key) {

        return properties.getProperty(key);
    }
}
