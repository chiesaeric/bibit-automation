package bibit.framework.tests.runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)

@CucumberOptions(

    features =
        "src/test/resources/features",


    glue =
        {
          "bibit.framework.tests.steps.web",
          "bibit.framework.tests.hooks",
        },
    tags = "@ui",
    plugin =
        {
          "pretty",
          "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },


    monochrome = true,


    publish = false

)


public class RunUiTest {

}