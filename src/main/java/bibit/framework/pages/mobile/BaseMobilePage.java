package bibit.framework.pages.mobile;

import bibit.framework.config.ConfigReader;
import bibit.framework.driver.MobileDriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** BaseMobilePage class for mobile base page. */
public class BaseMobilePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    /** Constructor for BaseMobilePage. */
    public BaseMobilePage() {

        driver = MobileDriverFactory.getDriver();
        long timeout = Long.parseLong(ConfigReader.get("mobile.timeout"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    /** Click element on mobile page. */
    /**
     * @param element WebElement to click
     */
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /** Type text on mobile page. */
    /**
     * @param element WebElement to type text
     * @param text    Text to type
     */
    protected void type(WebElement element, String text) {

        element.clear();

        element.sendKeys(text);
    }

    /** Get text from element on mobile page. */
    /**
     * @param element WebElement to get text
     * @return Text from element
     */
    protected String getText(WebElement element) {

        return element.getText();
    }

    /** Check if element is displayed on mobile page. */
    /**
     * @param element WebElement to check
     * @return True if element is displayed, False otherwise
     */
    protected boolean isDisplayed(WebElement element) {

        try {

            return element.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    /** Hide keyboard on mobile page. */
    /**
     * @param element WebElement to hide keyboard
     */
    protected void hideKeyboard() {

        try {

            driver.hideKeyboard();

        } catch (Exception ignored) {

        }
    }

    /** Scroll to text on mobile page. */
    /**
     * @param text Text to scroll to
     */
    protected void scrollToText(String text) {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().text(\""
                                + text
                                + "\"))"));
    }

    /** Wait for seconds on mobile page. */
    /**
     * @param second Number of seconds to wait
     */
    protected void waitForSeconds(long second) {

        try {

            Thread.sleep(second * 1000);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }

    /** Get dynamic object on mobile page. */
    /**
     * @param color   Color of the object
     * @param element Xpath of the object
     * @return WebElement of the object
     */
    public WebElement getObjectDynamic(String color, String element) {

        return driver.findElement(By.xpath(String.format(element, color)));
    }
}
