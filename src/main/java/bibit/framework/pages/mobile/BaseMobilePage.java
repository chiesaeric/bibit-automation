package bibit.framework.pages.mobile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import bibit.framework.driver.MobileDriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BaseMobilePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BaseMobilePage() {

        driver = MobileDriverFactory.getDriver();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

    }

    protected void click(
            WebElement element
    ) {

        element.click();

    }

    protected void type(
            WebElement element,
            String text
    ) {

        element.clear();

        element.sendKeys(
                text
        );

    }

    protected String getText(
            WebElement element
    ) {

        return element.getText();

    }

    protected boolean isDisplayed(
            WebElement element
    ) {

        try {

            return element.isDisplayed();

        } catch (Exception e) {

            return false;

        }

    }

    protected void hideKeyboard() {

        try {

            driver.hideKeyboard();

        } catch (Exception ignored) {

        }

    }

    protected void scrollToText(
            String text
    ) {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().text(\""
                                + text
                                + "\"))"
                )
        );

    }

    protected void waitForSeconds(
            long second
    ) {

        try {

            Thread.sleep(
                    second * 1000
            );

        } catch (InterruptedException e) {

            Thread.currentThread()
                    .interrupt();

        }

    }

    public WebElement getObjectDynamic(String color, String element) {

        return driver.findElement(
                By.xpath(
                        String.format(
                            element,
                            color
                        )
                )
        );
    }

}