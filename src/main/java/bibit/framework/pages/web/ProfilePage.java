package bibit.framework.pages.web;

import bibit.framework.config.ConfigReader;
import bibit.framework.objects.web.ProfileObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/** ProfilePage class for web pages. */
/**
 * @param driver WebDriver instance
 */
public class ProfilePage extends BasePage {

    private ProfileObject object;

    /** ProfilePage constructor. */
    /**
     * @param driver WebDriver instance
     */
    public ProfilePage(WebDriver driver) {

        super(driver);
        object = new ProfileObject();
        PageFactory.initElements(driver, object);
    }

    /** Open profile page on web page. */
    /**
     * @param driver WebDriver instance
     */
    public void openProfilePage() {
        openUrl(ConfigReader.get("web.url") + "profile");
        wait.until(isTrue -> isDisplayed(object.aLogout));
    }

    /** Click logout button on web page. */
    /**
     * @param driver WebDriver instance
     */
    public void clickLogout() {
        click(object.aLogout);
    }

    /** Check if logout button is displayed on web page. */
    /**
     * @param driver WebDriver instance
     */
    public boolean isLogOut() {
        return isDisplayed(object.aDaftar);
    }
}
