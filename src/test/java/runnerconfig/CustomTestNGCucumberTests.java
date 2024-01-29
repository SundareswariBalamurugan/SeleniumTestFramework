package runnerconfig;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public abstract class CustomTestNGCucumberTests implements ITest {
    private TestNGCucumberRunner testNGCucumberRunner;

    private final ThreadLocal<String> testName = new ThreadLocal<>();

    /**
     * Returns two-dimensional array of {@link PickleWrapper}s with their associated {@link FeatureWrapper}s.
     *
     * @param context Test context with information and parameter about/for the tests
     * @return a two-dimensional array of scenarios features.
     */

    @DataProvider
    public abstract Object[][] scenarios(ITestContext context);
    //Abstract-End

    //Override

    /**
     * Get the current test name.
     *
     * @return String test name
     */
    @Override
    public String getTestName() {
        return testName.get();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    protected TestNGCucumberRunner getTestNGCucumberRunner() {
        return testNGCucumberRunner;
    }

    /**
     * Get test name ThreadLocal object.
     *
     * @return ThreadLocal object containing name
     */
    public ThreadLocal<String> getTestNameObject() {
        return testName;
    }


    /**
     * Run a test scenario.
     *
     * @param pickleWrapper  PickleWrapper with details about the scenario
     * @param featureWrapper FeatureWrapper for the feature used in the scenario
     */
    @Test(groups = "cucumber", dataProvider = "scenarios")
    public void runScenario(final PickleWrapper pickleWrapper, final FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }



}
