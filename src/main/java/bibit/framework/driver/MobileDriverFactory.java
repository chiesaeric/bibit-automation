package bibit.framework.driver;

import java.net.URL;

import bibit.framework.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MobileDriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver initialize() throws Exception {

        try {
            UiAutomator2Options options =
                    new UiAutomator2Options();

            options.setPlatformName(
                    ConfigReader.get("mobile.platformName")
            );

            options.setAutomationName(
                    ConfigReader.get("mobile.automationName")
            );

            options.setDeviceName(
                    ConfigReader.get("mobile.deviceName")
            );

            options.setAppPackage(
                    ConfigReader.get("mobile.appPackage")
            );

            options.setAppActivity(
                    ConfigReader.get("mobile.appActivity")
            );

            driver =
                    new AndroidDriver(
                            new URL(
                                    ConfigReader.get(
                                            "mobile.appiumUrl"
                                    )
                            ),
                            options
                    );

        } catch (Exception e) {

            System.out.println("====== MOBILE ERROR ======");
            e.printStackTrace();

            throw e;

        }

        return driver;

    }

    public static AndroidDriver getDriver() {

        return driver;

    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    
    }

}