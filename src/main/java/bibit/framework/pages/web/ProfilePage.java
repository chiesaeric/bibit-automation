package bibit.framework.pages.web;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import bibit.framework.config.ConfigReader;
import bibit.framework.objects.web.ProfileObject;



public class ProfilePage extends BasePage {
   

    private ProfileObject object;



    public ProfilePage(
            WebDriver driver
    ){

        super(driver);
        object = new ProfileObject();
        PageFactory.initElements(
            driver,
            object
        );

    }




    public void openProfilePage() {
        openUrl(
            ConfigReader.get("web.url")+"profile"
        );
        wait.until(isTrue -> isDisplayed(object.aLogout));
    }


 public void clickLogout() {
       click(object.aLogout);
    }

    public boolean isLogOut() {
        return isDisplayed(object.aDaftar);
     }

}