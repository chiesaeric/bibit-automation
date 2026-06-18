package bibit.framework.objects.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * HomeObject class for mobile home page.
 */
public class HomeObject {

        public final String locatorProduct = "//android.widget.TextView[@content-desc=\"Product Title\" and"
                        + " @text=\"%s\"]/preceding-sibling::android.widget.ImageView";

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
        public WebElement imgSort;

        public final String locatorFilter = "//android.widget.TextView[@text=\"%s\"]";

        public final String locatorPrice = "(//android.widget.TextView[@text=\"%s\"])[1]";
}
