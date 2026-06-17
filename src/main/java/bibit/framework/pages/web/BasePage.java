package bibit.framework.pages.web;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bibit.framework.config.ConfigReader;



public class BasePage {


    protected WebDriver driver;

    protected WebDriverWait wait;



    public BasePage(
            WebDriver driver
    ){

        this.driver = driver;
        long wait = Long.parseLong(ConfigReader.get("web.timeout"));

        this.wait =
            new WebDriverWait(
                driver,
                Duration.ofSeconds(wait)
            );

            

    }



    protected void click(
            WebElement element
    ){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }





    protected void type(
            WebElement element,
            String value
    ){

        wait.until(
            ExpectedConditions
                .visibilityOf(element)
        );


        element.clear();

        element.sendKeys(value);

    }





    protected String getText(
            WebElement element
    ){

        wait.until(
            ExpectedConditions
                .visibilityOf(element)
        );


        return element.getText();

    }





    protected boolean isDisplayed(
            WebElement element
    ){

        wait.until(
            ExpectedConditions
                .visibilityOf(element)
        );


        return element.isDisplayed();

    }





    protected void openUrl(
            String url
    ){

        driver.get(url);

    }

}