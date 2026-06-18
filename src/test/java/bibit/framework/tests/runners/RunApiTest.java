package bibit.framework.tests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** RunApiTest class for API tests. */
/**
 * @param driver WebDriver instance
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"bibit.framework.tests.steps.api", "bibit.framework.tests.hooks"},
    tags = "@api",
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    monochrome = true)
public class RunApiTest {}
