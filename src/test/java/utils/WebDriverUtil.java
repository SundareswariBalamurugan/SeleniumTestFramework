package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtil {
    @Setter
    @Getter
    private static WebDriver driver;
//    String driver_option = "Chrome";


    private WebDriverUtil() {
    }

    public static WebDriver getInstance(){
        if(driver==null){
            setDriver(launchChrome());
        }
        return driver;
    }

    //    This method is used to launch Chrome
    public static WebDriver launchChrome(){
       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
//       options.addArguments("--incognito");
//       options.addArguments("--headless");
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
