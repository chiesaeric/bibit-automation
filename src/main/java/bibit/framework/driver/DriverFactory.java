package bibit.framework.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import bibit.framework.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverFactory {


    private static WebDriver driver;



    public static void initDriver(){


        String browser =
    System.getProperty(
        "browser",
        ConfigReader.get("browser")
    );


        if(browser == null){

            browser = "chrome";

        }



        switch(browser.toLowerCase()){


        case "chrome":


            WebDriverManager
                .chromedriver()
                .setup();


            ChromeOptions chromeOptions =
                new ChromeOptions();


            chromeOptions.addArguments(
                "--start-maximized"
            );


            driver =
                new ChromeDriver(
                    chromeOptions
                );


            break;




        case "firefox":


            WebDriverManager
                .firefoxdriver()
                .setup();


            driver =
                new FirefoxDriver();


            break;




        default:

            throw new RuntimeException(
                "Browser not supported : "
                + browser
            );

    }

    }





    public static WebDriver getDriver(){

        if(driver == null){

            throw new IllegalStateException(
                "Driver is not initialized"
            );

        }


        return driver;

    }





    public static void quitDriver(){


        if(driver != null){

            driver.quit();

            driver = null;

        }

    }

}