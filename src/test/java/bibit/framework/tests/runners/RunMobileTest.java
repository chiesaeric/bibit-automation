package bibit.framework.tests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** RunMobileTest class for mobile tests. */
/**
 * @param driver WebDriver instance
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "bibit.framework.tests",
    tags = "@mobile",
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class RunMobileTest {}
