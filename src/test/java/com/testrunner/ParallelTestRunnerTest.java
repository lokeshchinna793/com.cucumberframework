package com.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/featurefiles/LoginArtofTesting.feature",  // ✅ This must match your actual path
    glue = "com.stepdefinations",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class ParallelTestRunnerTest extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
