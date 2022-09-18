package step_definitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.sql.Timestamp;

import static driver.driverFactory.cleanupDriver;
import static driver.driverFactory.getDriver;

public class Hooks {
    //in this class we add the hooks that are common and reusable for multiple classes,
    // but we can't extend classes which have cucumber hooks :(
    static WebDriver driver;

    @Before
    public static void setup() {
        // we have to simply import the static method by clicking in more action from driverFactory
        getDriver();
    }

    @AfterStep     // for failed steps it will take screenshot and attached to cucumber report
    public static void captureFailedStep(Scenario scenario) {
        if (scenario.isFailed()){   //this is for failed steps
//if (!scenario.isFailed()){  // this line can be used for passed steps :)
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliSecond = Long.toString(timestamp.getTime());
            byte[] screenShot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", timeMilliSecond);
        }

    }


    @After
    public static void tear_down() {
        cleanupDriver();
    }
}
