package RunnerTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		
       features= "C:\\Users\\Anand\\eclipse-workspace3\\AutomationTestingTask\\src\\main\\java\\Features\\FeatureFile.feature",
		
		glue = {"StepDefinition"},
		
		monochrome = true,
		
		dryRun = false
		
		)


public class Runner {

}
