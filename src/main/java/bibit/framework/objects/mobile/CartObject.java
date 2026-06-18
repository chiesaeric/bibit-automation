package bibit.framework.objects.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/** Cart object class for mobile cart page. */
public class CartObject {

        public final String locatorColor = "//android.widget.ImageView[@content-desc='%s color']";

        @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
        public WebElement btnIncrease;

        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
        public WebElement txtQty;

        @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
        public WebElement btnAtc;

        @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
        public WebElement btnCart;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
        public WebElement btnCheckout;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
        public WebElement iptName;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
        public WebElement iptAddress;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
        public WebElement iptCity;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
        public WebElement iptZip;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
        public WebElement iptCountry;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
        public WebElement btnPayment;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
        public WebElement iptCardName;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
        public WebElement iptNoCard;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
        public WebElement iptExpDate;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
        public WebElement iptScurityCode;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
        public WebElement btnReviewOrder;

        @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
        public WebElement btnPlaceOrder;

        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/completeTV\"]")
        public WebElement txtSuccess;
}
