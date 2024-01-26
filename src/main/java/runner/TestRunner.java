package runner;


import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.WebDriverUtil;




@CucumberOptions(plugin = {"pretty", "html:../reports/", "json:reports/cucumber.json"},
        features = {"src/test/resources/features"}, glue = {"runner", "glue", "stepdefs"},
        tags = "@Test1" )

@Test(priority = 1)
@Slf4j
public class TestRunner extends CustomTestNGCucumberTests{
    WebDriverUtil driverUtil = new WebDriverUtil();
//
    @AfterMethod
    public void tearDown() {
       driverUtil.getDriver().quit();
    }

//    @BeforeClass
//    public void beforeClass() {
//        driverUtil.launchChrome();
//
//    }

    @DataProvider
    @Override
    public Object[][] scenarios(final ITestContext context) {
        if (getTestNGCucumberRunner() == null) {
            return new Object[0][0];
        }
        return getTestNGCucumberRunner().provideScenarios();
    }
}
