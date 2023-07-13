package com.rms.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report.html"},
        glue = "com/rms/step_definitions/api",
        features = "@target/rerun.txt"
)

public class FailedTestRunner {

}