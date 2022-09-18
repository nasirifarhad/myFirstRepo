package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@CucumberOptions   (
        features = {"classpath:features"},
        glue = {"step_definitions"},
        tags = "@login",
        monochrome = false,
        dryRun = false,
        publish = true,
        plugin = { "pretty" ,
                "html:reports/html_report",
                "json:reports/j_report.json",
                "junit:reports/junit_report"}
)
/**1- tags will run our specific feature file, in feature files above Feature: add @test123 or
any name you want then pass it here in tags
2- monochrome true will provide console detail
3- dryRun true won't run the step definition codes and won't open browser
4- plugin, when write "pretty" it will show us more details in console logs
 the second is html report which will be generated anywhere we specify now we indicate
target folder and the report name would be after slush /
 the third expression is generating json report which is used in jenkins CI to generate
reports*/


public class RunnerClass extends AbstractTestNGCucumberTests {
    //below override method enable us to execute multiple scenarios at the same time (parallel)
    //of course from here (runnerClass) when you pass the feature file tag in tags, like @login.
    // if there are numerous scenarios in one feature file it will be run in parallel
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
