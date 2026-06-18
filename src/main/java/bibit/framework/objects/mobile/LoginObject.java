package bibit.framework.objects.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/** LoginObject class for mobile login page. */
public class LoginObject {

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
        public WebElement imgViewMenu;

        @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Login Menu Item\"]")
        public WebElement textViewLogin;

        @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")
        public WebElement iptUsername;

        @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")
        public WebElement iptPassword;

        @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]")
        public WebElement btnLogin;

        @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Logout Menu Item\"]")
        public WebElement btnLogout;

        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and"
                        + " @text=\"About\"]")
        public WebElement btnAbout;
}
