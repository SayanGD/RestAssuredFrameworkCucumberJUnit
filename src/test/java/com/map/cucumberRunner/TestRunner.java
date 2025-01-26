package com.map.cucumberRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue={"com.map.stepDefinitions"},
		tags="@DeletePlace",
		plugin="json:target/jsonReports/cucumber-report.json"
		)

public class TestRunner
{

}