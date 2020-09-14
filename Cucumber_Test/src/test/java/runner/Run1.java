
package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue="Scripts")

public class Run1 {

}
