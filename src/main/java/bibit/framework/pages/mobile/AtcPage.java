package bibit.framework.pages.mobile;

import org.openqa.selenium.support.PageFactory;

import bibit.framework.objects.mobile.CartObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AtcPage extends BaseMobilePage{

    private CartObject object;

    public AtcPage(AndroidDriver driver) {
        object = new CartObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),object);

    }

    public void chooseColor(String color) {
        click(getObjectDynamic(color, object.COLOR_LOCATOR));
    }

    public void chooseQty(String qty) {
        String getQtyText = getText(object.txtQty);
        do {
            click(object.btnIncrease);
            waitForSeconds(1);
            getQtyText = getText(object.txtQty);
        } while (!getQtyText.equalsIgnoreCase(qty));
        
    }

    public void clickAtc() {
        // TODO Auto-generated method stub
        click(object.btnAtc);
        
    }

    public void GoToCartPage() {
        // TODO Auto-generated method stub
        click(object.btnCart);
        wait.until(isTrue -> isDisplayed(object.btnCheckout));
    }

    public void clickCheckout() {
        // TODO Auto-generated method stub
        click(object.btnCheckout);
        wait.until(isTrue -> isDisplayed(object.iptName));
    }

    public void insertName(String name) {
        // TODO Auto-generated method stub
        type(object.iptName, name);
        waitForSeconds(1);
    }

    public void insertAddress(String address) {
        // TODO Auto-generated method stub
        type(object.iptAddress, address);
        waitForSeconds(1);
    }

    public void insertCity(String city) {
        // TODO Auto-generated method stub
        type(object.iptCity, city);
        waitForSeconds(1);    
    }

    public void insertZip(String zip) {
        // TODO Auto-generated method stub
        type(object.iptZip, zip);
        waitForSeconds(1);    
    
    }

    public void insertCountry(String country) {
        // TODO Auto-generated method stub
        type(object.iptCountry, country);
        waitForSeconds(1);
    }

    public void clickPayment() {
        // TODO Auto-generated method stub
        click(object.btnPayment);
        wait.until(isTrue -> isDisplayed(object.iptCardName));
    }

    public void insertCardName(String cardName) {
        // TODO Auto-generated method stub
        type(object.iptCardName, cardName);
        waitForSeconds(1);
    }

    public void insertCardNumber(String cardNo) {
        // TODO Auto-generated method stub
        type(object.iptNoCard, cardNo);
        waitForSeconds(1);

    }

    public void insertExpDate(String expDate) {
        // TODO Auto-generated method stub
        type(object.iptExpDate, expDate);
        waitForSeconds(1);
    }

    public void securityCode(String securityCode) {
        // TODO Auto-generated method stub
        type(object.iptScurityCode, securityCode);
        waitForSeconds(1);
    }

    public void clickReviewOrder() {
        // TODO Auto-generated method stub
        click(object.btnReviewOrder);
        wait.until(isTrue -> isDisplayed(object.btnPlaceOrder));

    }

    public void clickPlaceOrder() {
        // TODO Auto-generated method stub
        click(object.btnPlaceOrder);
        wait.until(isTrue -> isDisplayed(object.txtSuccess));
    }

    public boolean isDisplaySuccess() {
        // TODO Auto-generated method stub
        return isDisplayed(object.txtSuccess);
    }

}
