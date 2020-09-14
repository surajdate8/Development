package com.step.definations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature",
glue= {"StepDefinitions"},
monochrome = true,
plugin = {"pretty","html:target/HtmlReports",
		"junit:target/JunitReports/Report.xml",
		"json:target/JsonReports/Report.json"
}
		)
public class TestRunner_Run_With_Single_Tag {

}
