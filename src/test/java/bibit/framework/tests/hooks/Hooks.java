package bibit.framework.tests.hooks;

import bibit.framework.driver.DriverFactory;
import bibit.framework.driver.MobileDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/** Hooks class for Cucumber tests. */
/**
 * @param driver WebDriver instance
 */
public class Hooks {

    /** Hooks constructor. */
    /**
     * @param driver WebDriver instance
     */
    @Before
    public void setUp() {

        System.out.println("============================== START TEST ==============================");
    }

    /** Hooks constructor. */
    /**
     * @param driver WebDriver instance for UI tests
     */
    @Before("@ui")
    public void setUpUi() {
        Allure.label("parentSuite", "UI/Web");
        DriverFactory.initDriver();
    }

    /** Hooks constructor. */
    /**
     * @param driver WebDriver instance for mobile tests
     */
    @Before("@mobile")
    public void beforeMobile() throws Exception {
        Allure.label("parentSuite", "Mobile");
        MobileDriverFactory.initialize();
    }

    /** Hooks constructor. */
    /**
     * @param driver WebDriver instance for API tests
     */
    @Before("@api")
    public void beforeApi() throws Exception {
        Allure.label("parentSuite", "API");
    }

    // @AfterStep("@ui")
    // public void afterStep(
    // Scenario scenario
    // ){
    // if (!scenario.isFailed()){
    // takeScreenshot(
    // scenario
    // );
    // }

    // }

    // @AfterStep("@mobile")
    // public void afterStepMobile(
    // Scenario scenario
    // ){
    // if (!scenario.isFailed()){
    // takeScreenshotMobile(
    // scenario
    // );
    // }
    // }

    /** Hooks constructor. */
    /**
     * @param driver WebDriver instance
     */
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("============================== END TEST ==============================");
    }

    /** Hooks constructor. */
    /**
     * @param driver WebDriver instance for UI tests
     */
    @After("@ui")
    public void tearDownUi(Scenario scenario) {

        takeScreenshot(scenario, "web");
        DriverFactory.quitDriver();
    }

    /** Hooks constructor. */
    /**
     * @param driver WebDriver instance for mobile tests
     */
    @After("@mobile")
    public void afterMobile(Scenario scenario) {

        takeScreenshot(scenario, "mobile");
        MobileDriverFactory.quitDriver();
    }

    /** Hooks constructor. */
    /**
     * @param driver WebDriver instance for UI tests
     */
    private void takeScreenshot(Scenario scenario, String platform) {

        if (platform.equals("web")) {
            try {

                if (DriverFactory.getDriver() == null) {
                    return;
                }

                byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshot, "image/png", "Evidence");

            } catch (Exception e) {

                System.out.println("Failed take screenshot : " + e.getMessage());
            }
        } else {
            try {

                if (MobileDriverFactory.getDriver() == null) {
                    return;
                }

                byte[] screenshot = ((TakesScreenshot) MobileDriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshot, "image/png", "Evidence");

            } catch (Exception e) {

                System.out.println("Failed take mobile screenshot : " + e.getMessage());
            }
        }
    }
}
