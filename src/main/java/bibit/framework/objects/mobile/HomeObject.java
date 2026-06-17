package bibit.framework.objects.mobile;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeObject {

        public final String PRODUCT_LOCATOR = "//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"%s\"]/preceding-sibling::android.widget.ImageView";
        
        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
        public WebElement imgSort;

        public final String FILTER_LOCATOR = "//android.widget.TextView[@text=\"%s\"]";

        public final String PRICE_LOCATOR = "(//android.widget.TextView[@text=\"%s\"])[1]";
                
}