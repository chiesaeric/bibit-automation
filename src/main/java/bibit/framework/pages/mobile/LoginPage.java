package bibit.framework.pages.mobile;

import org.openqa.selenium.support.PageFactory;

import bibit.framework.objects.mobile.LoginObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseMobilePage{

    private LoginObject object;

    public LoginPage(AndroidDriver driver) {
        object = new LoginObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),object);

    }

    public void clickIconHamburger() 
    {
        click(object.imgViewMenu);
        wait.until(isTrue -> isDisplayed(object.btnAbout));
    }

    public void clickLoginMenu() 
    {
        click(object.textViewLogin);
        wait.until(isTrue -> isDisplayed(object.btnLogin));
    }

    public void inputUsername(String username) 
    {
        type(object.iptUsername, username);
        waitForSeconds(1);
    }

    public void inputPassword(String password) 
    {
        type(object.iptPassword, password);
        waitForSeconds(1);
    }

    public void clickButtonLogin() 
    {
        click(object.btnLogin);
        waitForSeconds(2);
    }

    public boolean isLogin(){
        return isDisplayed(
            object.btnLogout
        );
    }

    public void waitMenuShow() 
    {
        wait.until(isTrue -> isDisplayed(object.imgViewMenu));
    }

}