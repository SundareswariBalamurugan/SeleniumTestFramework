package runnerconfig;



import io.cucumber.junit.Cucumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions( features = "src/test/resources/features", plugin = { "pretty" ,"json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml","html:target/cucumber-reports/reports2.html"}, monochrome = true, glue = {
        "com.stepdefs" }, tags = "@Test1" )

@Slf4j
public class TestRunner  {

}
