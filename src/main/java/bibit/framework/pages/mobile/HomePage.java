package bibit.framework.pages.mobile;

import org.openqa.selenium.support.PageFactory;

import bibit.framework.objects.mobile.CartObject;
import bibit.framework.objects.mobile.HomeObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BaseMobilePage{

    private HomeObject object;
    private CartObject cartObject;

    public HomePage(AndroidDriver driver) {
        object = new HomeObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),object);
        cartObject = new CartObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),cartObject);

    }

    public void clickProduct(String product) 
    {
        click(getObjectDynamic(product, object.PRODUCT_LOCATOR));
        wait.until(isTrue -> isDisplayed(cartObject.btnAtc));
    }

    public void clickFilter() {
        // TODO Auto-generated method stub
        click(object.imgSort);
    }

    public void clickFilterValue(String filter) {
        // TODO Auto-generated method stub
        wait.until(isTrue -> isDisplayed(getObjectDynamic(filter, object.FILTER_LOCATOR)));
        click(getObjectDynamic(filter, object.FILTER_LOCATOR));
    }

    public boolean isDisplayNameFilter(String name) {
        // TODO Auto-generated method stub
        return isDisplayed(getObjectDynamic(name, object.PRODUCT_LOCATOR));
        
    }

    public boolean isDisplayPriceFilter(String price) {
        // TODO Auto-generated method stub
        return isDisplayed(getObjectDynamic(price, object.PRICE_LOCATOR));
        
    }

}
