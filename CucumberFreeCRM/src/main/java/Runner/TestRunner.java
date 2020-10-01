package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//If showing error for RunWith -> go to POM.xml and remove scope from Junit
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features",
				glue= {"stepDefination"})
public class TestRunner {

}
