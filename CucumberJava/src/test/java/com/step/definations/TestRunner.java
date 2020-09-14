package com.step.definations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature_With_Tags",
glue= {"StepDefinitions"},
tags = {"@smoke or  @regression and @important"}

		)
public class TestRunner {

}
