package bibit.framework.pages.mobile;

import bibit.framework.objects.mobile.CartObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * AtcPage class for mobile atc page.
 */
public class AtcPage extends BaseMobilePage {

    private CartObject object;

    /**
     * AtcPage constructor.
     * 
     * @param driver AndroidDriver instance
     */
    public AtcPage(AndroidDriver driver) {
        object = new CartObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver), object);
    }

    /**
     * Choose color on atc page.
     * 
     * @param color Color to choose
     */
    public void chooseColor(String color) {
        click(getObjectDynamic(color, object.locatorColor));
    }

    /**
     * Choose quantity on atc page.
     * 
     * @param qty Quantity to choose
     */
    public void chooseQty(String qty) {
        String getQtyText = getText(object.txtQty);
        do {
            click(object.btnIncrease);
            waitForSeconds(1);
            getQtyText = getText(object.txtQty);
        } while (!getQtyText.equalsIgnoreCase(qty));
    }

    /**
     * Click Add to Cart button on atc page.
     */
    public void clickAtc() {
        click(object.btnAtc);
    }

    /**
     * Click Cart button on atc page.
     */
    public void GoToCartPage() {
        click(object.btnCart);
        wait.until(isTrue -> isDisplayed(object.btnCheckout));
    }

    /**
     * Click Checkout button on atc page.
     */
    public void clickCheckout() {
        click(object.btnCheckout);
        wait.until(isTrue -> isDisplayed(object.iptName));
    }

    /**
     * Insert name on atc page.
     * 
     * @param name Name to insert
     */
    public void insertName(String name) {
        type(object.iptName, name);
        waitForSeconds(1);
    }

    /**
     * Insert address on atc page.
     * 
     * @param address Address to insert
     */
    public void insertAddress(String address) {
        type(object.iptAddress, address);
        waitForSeconds(1);
    }

    /**
     * Insert city on atc page.
     * 
     * @param city City to insert
     */
    public void insertCity(String city) {
        type(object.iptCity, city);
        waitForSeconds(1);
    }

    /**
     * Insert zip on atc page.
     * 
     * @param zip Zip to insert
     */
    public void insertZip(String zip) {
        type(object.iptZip, zip);
        waitForSeconds(1);
    }

    /**
     * Insert country on atc page.
     * 
     * @param country Country to insert
     */
    public void insertCountry(String country) {
        type(object.iptCountry, country);
        waitForSeconds(1);
    }

    /**
     * Click Payment button on atc page.
     */
    public void clickPayment() {
        click(object.btnPayment);
        wait.until(isTrue -> isDisplayed(object.iptCardName));
    }

    /**
     * Insert card name on atc page.
     * 
     * @param cardName Card name to insert
     */
    public void insertCardName(String cardName) {
        type(object.iptCardName, cardName);
        waitForSeconds(1);
    }

    /**
     * Insert card number on atc page.
     * 
     * @param cardNo Card number to insert
     */
    public void insertCardNumber(String cardNo) {
        type(object.iptNoCard, cardNo);
        waitForSeconds(1);
    }

    /**
     * Insert expiration date on atc page.
     * 
     * @param expDate Expiration date to insert
     */
    public void insertExpDate(String expDate) {
        type(object.iptExpDate, expDate);
        waitForSeconds(1);
    }

    /**
     * Insert security code on atc page.
     * 
     * @param securityCode Security code to insert
     */
    public void securityCode(String securityCode) {
        type(object.iptScurityCode, securityCode);
        waitForSeconds(1);
    }

    /**
     * Click Review Order button on atc page.
     */
    public void clickReviewOrder() {
        click(object.btnReviewOrder);
        wait.until(isTrue -> isDisplayed(object.btnPlaceOrder));
    }

    /**
     * Click Place Order button on atc page.
     */
    public void clickPlaceOrder() {
        click(object.btnPlaceOrder);
        wait.until(isTrue -> isDisplayed(object.txtSuccess));
    }

    /**
     * Check if success message is displayed on atc page.
     * 
     * @return True if success message is displayed, False otherwise
     */
    public boolean isDisplaySuccess() {
        return isDisplayed(object.txtSuccess);
    }
}
