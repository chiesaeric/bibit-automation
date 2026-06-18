package bibit.framework.pages.web;

import bibit.framework.config.ConfigReader;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** BasePage class for web pages. */
public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    /** BasePage constructor. */
    /**
     * @param driver WebDriver instance
     */
    public BasePage(WebDriver driver) {

        this.driver = driver;
        long wait = Long.parseLong(ConfigReader.get("web.timeout"));

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(wait));
    }

    /** Click element on web page. */
    /**
     * @param element WebElement to click
     */
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /** Type text into element on web page. */
    /**
     * @param element WebElement to type into
     * @param value   Text to type
     */
    protected void type(WebElement element, String value) {

        wait.until(ExpectedConditions.visibilityOf(element));

        element.clear();

        element.sendKeys(value);
    }

    /** Get text from element on web page. */
    /**
     * @param element WebElement to get text from
     * @return Text content of the element
     */
    protected String getText(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

        return element.getText();
    }

    /** Check if element is displayed on web page. */
    /**
     * @param element WebElement to check
     * @return True if element is displayed, false otherwise
     */
    protected boolean isDisplayed(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

        return element.isDisplayed();
    }

    /** Open URL on web page. */
    /**
     * @param url URL to open
     */
    protected void openUrl(String url) {

        driver.get(url);
    }
}
