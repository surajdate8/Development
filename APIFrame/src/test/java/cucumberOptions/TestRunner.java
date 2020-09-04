package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		plugin = {"pretty", "html:target/HtmlReports/Report.html",
						"junit:target/JunitReports/Report.xml",
						"json:target/JsonReports/Report.json",
						"json:target/jsonReports/cucumber-report.json"},
		glue="stepDefination",
		tags="@Regression"
		)
public class TestRunner {
	

}

