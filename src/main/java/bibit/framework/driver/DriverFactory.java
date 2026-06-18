package bibit.framework.driver;

import bibit.framework.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/** Driver factory class for creating and managing web drivers. */
public class DriverFactory {

  private static WebDriver driver;

  /** Initialize the web driver. */
  public static void initDriver() {

    String browser = System.getProperty("browser", ConfigReader.get("browser"));

    if (browser == null) {

      browser = "chrome";
    }

    /** Create the web driver instance. */
    switch (browser.toLowerCase()) {
      case "chrome":
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(chromeOptions);

        break;

      case "firefox":
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        break;

      default:
        throw new RuntimeException("Browser not supported : " + browser);
    }
  }

  /** Get the initialized web driver instance. */
  /** @return Initialized web driver instance */
  public static WebDriver getDriver() {

    if (driver == null) {

      throw new IllegalStateException("Driver is not initialized");
    }

    return driver;
  }

  /** Quit the web driver instance. */
  /** @throws IllegalStateException if the driver is not initialized */
  public static void quitDriver() {

    if (driver != null) {

      driver.quit();

      driver = null;
    }
  }
}
