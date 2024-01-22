package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtil {
    @Setter
    @Getter
    WebDriver driver;
//    String driver_option = "Chrome";

    public WebDriverUtil() {
        setDriver(launchChrome());
    }

//    This method is used to launch Chrome
    public WebDriver launchChrome(){
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //    This method is used to launch Safari
    public WebDriver launchSafari(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().maximize();
        return driver;
    }


}
