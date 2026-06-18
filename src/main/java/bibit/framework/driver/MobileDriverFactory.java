package bibit.framework.driver;

import bibit.framework.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;

/** Mobile driver factory class for creating and managing mobile drivers. */
public class MobileDriverFactory {

        private static AndroidDriver driver;

        /** Initialize the mobile driver. */
        /** @throws Exception if the driver initialization fails */
        /** @return Initialized mobile driver instance */
        public static AndroidDriver initialize() throws Exception {

                try {
                        UiAutomator2Options options = new UiAutomator2Options();

                        options.setPlatformName(ConfigReader.get("mobile.platformName"));

                        options.setAutomationName(ConfigReader.get("mobile.automationName"));

                        options.setDeviceName(ConfigReader.get("mobile.deviceName"));

                        options.setAppPackage(ConfigReader.get("mobile.appPackage"));

                        options.setAppActivity(ConfigReader.get("mobile.appActivity"));

                        driver = new AndroidDriver(new URL(ConfigReader.get("mobile.appiumUrl")), options);

                } catch (Exception e) {

                        System.out.println("====== MOBILE ERROR ======");
                        e.printStackTrace();

                        throw e;
                }

                return driver;
        }

        /** Get the initialized mobile driver instance. */
        /** @return Initialized mobile driver instance */
        public static AndroidDriver getDriver() {

                return driver;
        }

        /** Quit the mobile driver instance. */
        /** @throws IllegalStateException if the driver is not initialized */
        public static void quitDriver() {

                if (driver != null) {
                        driver.quit();
                        driver = null;
                }
        }
}
