package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.DataLoadingUtil;
import utils.HelperUtil;
import utils.WebDriverUtil;

import java.time.Duration;

public class TestFrameworkPage {

    private static final WebDriverUtil driverUtil =new WebDriverUtil();

    static WebDriver driver;
    static DataLoadingUtil dataLoadingUtil;
    public HelperUtil helper;

    public static final String USERNAME_FIELD = "userName";
    static By userName = By.id(USERNAME_FIELD);
    public TestFrameworkPage() {
        driver = driverUtil.getDriver();
        helper =  new HelperUtil(driver);
        dataLoadingUtil = new DataLoadingUtil();
    }

    public void launchUrl(String urlPage) throws WebDriverException {

        driver.get((dataLoadingUtil.fetchConfigValue("url")+urlPage));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

    }

}
