package com.testrunner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("featurefiles/LoginArtofTesting.feature") // not the full path, just folder
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.stepdefinations")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/report.html")
//@IncludeTags({"Sanity", "Regression"})
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Smoke and not @Sanity")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Smoke and @Sanity")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Smoke and @Regression")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Smoke or @Sanity")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "(@Sanity or @Regression) and @Smoke")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "(@Sanity and @Regression) and @Smoke")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "(@Sanity or @Regression) or @Smoke")
//@ExcludeTags("Sanity")
//@IncludeTags("Login")
//@IncludeTags("Login")
public class TestRunner {
	
}
