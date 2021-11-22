package Flink.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
// to run all test cases with runner. also we can group of test cases using tags.
// We can divide it as regression,smoke..
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/Resources/Features",
        glue = "Flink/stepDefinitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
