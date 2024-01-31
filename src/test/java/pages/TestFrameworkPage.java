package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.DataLoadingUtil;
import utils.HelperUtil;
import utils.WebDriverUtil;

import java.time.Duration;

public class TestFrameworkPage {



    static WebDriver driver;
    static DataLoadingUtil dataLoadingUtil;
    public HelperUtil helper;

    public static final String USERNAME_FIELD = "userName";
    static By userName = By.id(USERNAME_FIELD);
    public TestFrameworkPage() {
        driver = WebDriverUtil.getDriver();
        helper =  new HelperUtil();
        dataLoadingUtil = new DataLoadingUtil();
    }

    public void launchUrl(String urlPage) throws WebDriverException {
        if(urlPage.isEmpty()) {
            driver.get((dataLoadingUtil.fetchConfigValue("url") + urlPage));
        }else {
            driver.get(urlPage);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

    }

}
