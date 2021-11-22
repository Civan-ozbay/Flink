package Flink.stepDefinitions;


import Flink.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    //this method execute before starting each test case, can implement many situations according to the project
    @Before
    public void setUp() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("\tTest cases running");
        Driver.get().manage().window().maximize();
    }
    //this method execute after finishing each test case
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        Driver.closeDriver();

    }

}