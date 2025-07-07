package com.rms.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.rms.test.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json"
        },
        monochrome = true,
        publish = true
)
public class TestRunner {
}