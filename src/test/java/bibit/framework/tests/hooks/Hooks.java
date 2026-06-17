package bibit.framework.tests.hooks;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import bibit.framework.driver.DriverFactory;
import bibit.framework.driver.MobileDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;



public class Hooks {



    @Before
    public void setUp() {


        System.out.println(
            "============================== START TEST =============================="
        );

    }

    @Before("@ui")
    public void setUpUi() {
        Allure.label("parentSuite", "UI/Web");
        DriverFactory
            .initDriver();

    }

    @Before("@mobile")
    public void beforeMobile() throws Exception {
        Allure.label("parentSuite", "Mobile");
        MobileDriverFactory.initialize();

    }

    @Before("@api")
    public void beforeApi() throws Exception {
        Allure.label("parentSuite", "API");

    }

    // @AfterStep("@ui")
    // public void afterStep(
    //         Scenario scenario
    // ){
    //     if (!scenario.isFailed()){
    //         takeScreenshot(
    //             scenario
    //         );
    //     }

    // }

    // @AfterStep("@mobile")
    // public void afterStepMobile(
    //         Scenario scenario
    // ){
    //     if (!scenario.isFailed()){
    //         takeScreenshotMobile(
    //             scenario
    //         );
    //     }
    // }

    @After
    public void tearDown(
            Scenario scenario
    ) {
        System.out.println(
            "============================== END TEST =============================="
        );

    }

    @After("@ui")
    public void tearDownUi(
            Scenario scenario
    ) {

        takeScreenshot(scenario);
        DriverFactory
            .quitDriver();
    }


    @After("@mobile")
    public void afterMobile(Scenario scenario) {
       
        takeScreenshotMobile(scenario);
        MobileDriverFactory.quitDriver();

    }

    private void takeScreenshot(
        Scenario scenario
) {

    try {

        if (DriverFactory.getDriver() == null) {
            return;
        }

        byte[] screenshot =
                ((TakesScreenshot)
                        DriverFactory.getDriver())
                                .getScreenshotAs(
                                        OutputType.BYTES
                                );

        scenario.attach(
                screenshot,
                "image/png",
                "Evidence"
        );

    } catch (Exception e) {

        System.out.println(
                "Failed take web screenshot : "
                        + e.getMessage()
        );

    }

}

    private void takeScreenshotMobile(
        Scenario scenario
) {

    try {

        if (MobileDriverFactory.getDriver() == null) {
            return;
        }

        byte[] screenshot =
                ((TakesScreenshot)
                        MobileDriverFactory.getDriver())
                                .getScreenshotAs(
                                        OutputType.BYTES
                                );

        scenario.attach(
                screenshot,
                "image/png",
                "Evidence"
        );

    } catch (Exception e) {

        System.out.println(
                "Failed take mobile screenshot : "
                        + e.getMessage()
        );

    }

}

}