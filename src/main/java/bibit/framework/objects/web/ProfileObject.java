package bibit.framework.objects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileObject {
    @FindBy(xpath="//div[text()='Log Out']")
    public WebElement aLogout;

    @FindBy(xpath="//span[@data-testid='btn-content-nonlogin-register-btn']")
    public WebElement aDaftar;

    
}
