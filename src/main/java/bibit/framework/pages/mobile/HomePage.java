package bibit.framework.pages.mobile;

import bibit.framework.objects.mobile.CartObject;
import bibit.framework.objects.mobile.HomeObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/** HomePage class for mobile home page. */
public class HomePage extends BaseMobilePage {

    private HomeObject object;
    private CartObject cartObject;

    /** Constructor for HomePage. */
    /**
     * @param driver AndroidDriver instance
     */
    public HomePage(AndroidDriver driver) {
        object = new HomeObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver), object);
        cartObject = new CartObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartObject);
    }

    /** Click product on mobile page. */
    /**
     * @param product Product name to click
     */
    public void clickProduct(String product) {
        click(getObjectDynamic(product, object.locatorProduct));
        wait.until(isTrue -> isDisplayed(cartObject.btnAtc));
    }

    /** Click filter on mobile page. */
    /**
     * @param filter Filter value to click
     */
    public void clickFilter() {
        click(object.imgSort);
    }

    /** Click filter value on mobile page. */
    /**
     * @param filter Filter value to click
     */
    public void clickFilterValue(String filter) {
        wait.until(isTrue -> isDisplayed(getObjectDynamic(filter, object.locatorFilter)));
        click(getObjectDynamic(filter, object.locatorFilter));
    }

    /** Check if display name filter is displayed on mobile page. */
    /**
     * @param name Display name filter to check
     * @return True if the display name filter is displayed, False otherwise
     */
    public boolean isDisplayNameFilter(String name) {
        return isDisplayed(getObjectDynamic(name, object.locatorProduct));
    }

    /** Check if display price filter is displayed on mobile page. */
    /**
     * @param price Price filter to check
     * @return True if the price filter is displayed, False otherwise
     */
    public boolean isDisplayPriceFilter(String price) {
        return isDisplayed(getObjectDynamic(price, object.locatorPrice));
    }
}
