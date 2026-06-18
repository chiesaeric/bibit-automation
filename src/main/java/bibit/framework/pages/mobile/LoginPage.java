package bibit.framework.pages.mobile;

import bibit.framework.objects.mobile.LoginObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/** LoginPage class for mobile login page. */
public class LoginPage extends BaseMobilePage {

    private LoginObject object;

    /** LoginPage constructor. */
    /**
     * @param driver AndroidDriver instance
     */
    public LoginPage(AndroidDriver driver) {
        object = new LoginObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver), object);
    }

    /** Click icon hamburger on mobile page. */
    /**
     * @param icon Icon to click
     */
    public void clickIconHamburger() {
        click(object.imgViewMenu);
        wait.until(isTrue -> isDisplayed(object.btnAbout));
    }

    /** Click login menu on mobile page. */
    /**
     * @param menu Menu to click
     */
    public void clickLoginMenu() {
        click(object.textViewLogin);
        wait.until(isTrue -> isDisplayed(object.btnLogin));
    }

    /** Input username on mobile page. */
    /**
     * @param username Username to input
     */
    public void inputUsername(String username) {
        type(object.iptUsername, username);
        waitForSeconds(1);
    }

    /** Input password on mobile page. */
    /**
     * @param password Password to input
     */
    public void inputPassword(String password) {
        type(object.iptPassword, password);
        waitForSeconds(1);
    }

    /** Click button login on mobile page. */
    /**
     * @param button Button to click
     */
    public void clickButtonLogin() {
        click(object.btnLogin);
        waitForSeconds(2);
    }

    /** Check if login is successful on mobile page. */
    /**
     * @return True if login is successful, false otherwise
     */
    public boolean isLogin() {
        return isDisplayed(object.btnLogout);
    }

    /** Wait for menu to show on mobile page. */
    /**
     * @param menu Menu to wait for
     */
    public void waitMenuShow() {
        wait.until(isTrue -> isDisplayed(object.imgViewMenu));
    }
}
