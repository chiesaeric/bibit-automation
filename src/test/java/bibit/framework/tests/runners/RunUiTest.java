package bibit.framework.tests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
      "bibit.framework.tests.steps.web",
      "bibit.framework.tests.hooks",
    },
    tags = "@ui",
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    monochrome = true,
    publish = false)
public class RunUiTest {}
