package pages;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.DataLoadingUtil;
import utils.HelperUtil;
import utils.WebDriverUtil;
import java.time.Duration;
import java.util.*;


@Slf4j
public class Homepage {

    private static final WebDriverUtil driverUtil =new WebDriverUtil();

    static WebDriver driver;
    static DataLoadingUtil dataLoadingUtil;
    public HelperUtil helper;

    // Constructor to define the classes
    public Homepage() {
        driver = driverUtil.getDriver();
        helper =  new HelperUtil(driver);
        dataLoadingUtil = new DataLoadingUtil();
    }

    // Defining the locators
    public static final String USERNAME_FIELD = "userName";
    public static final String PASSWORD_FIELD = "password";
    public static final String LOGIN_BUTTON = "login";
    public static final String AFTERLOGINPAGE = "//div[@class='pattern-backgound playgound-header']/div";
    public static final String FULLNAME_FIELD = "#userName";
    public static final String email_FIELD = "#userEmail";
    public static final String currentAddress_FIELD = "#currentAddress";
    public static final String permanentAddress_FIELD = "#permanentAddress";
    public static final String submit_BUTTON = "//*[@id='submit']";

    public static final String expand_BUTTON = "//button[@class='rct-collapse rct-collapse-btn']";

    public static final String DESKTOP_CHECKBOX =  "tree-node-desktop";
    public static final String YES_RADIO =  "yesRadio";
    public static final String IMPRESSIVE_RADIO =  "impressiveRadio";
    public static final String NO_RADIO =  "noRadio";
    public static final String DOUBLECLICK =  "doubleClickBtn";
    public static final String DBCLICKMESSAGE =  "doubleClickMessage";
    public static final String RIGHTCLICKMESSAGE =  "rightClickMessage";
    public static final String RIGHTCLICK =  "rightClickBtn";
    public static final String SELECTED_OPTION =  "//p[@class='mt-3']/span";
    public static final String HOMELINK = "Home";
    public static final String DYNAMICLINK = "dynamicLink";
    public static final String CREATEDLINK = "Created";
    public static final String LINKRESPONSE = "linkResponse";
    public static final String PARTIALLINKRESPONSE = "Valid Link";
    public static final String UPLOADFILE = "uploadFile";


    String optionProvided ;
    String appUrl ;

    // Assigning the locators to corresponding By variables
  static By userName = By.id(USERNAME_FIELD);
  static By password = By.id(PASSWORD_FIELD);
  static By login = By.id(LOGIN_BUTTON);
  static By uploadFile = By.id(UPLOADFILE);
  static By yesradio = By.id(YES_RADIO);
  static By impressivradioe = By.id(IMPRESSIVE_RADIO);
  static By noradio = By.id(NO_RADIO);
  static By dbClick = By.id(DOUBLECLICK);
  static By dynamicLink = By.id(DYNAMICLINK);
  static By rightClick = By.id(RIGHTCLICK);
  static By dbCLickMessae = By.id(DBCLICKMESSAGE);
  static By rightCLickMessage = By.id(RIGHTCLICKMESSAGE);
  static By desktopCheckbox = By.id(DESKTOP_CHECKBOX);
  static By linkresponse = By.id(LINKRESPONSE);
  static By afterLoginPath = By.xpath(AFTERLOGINPAGE);
  static By fullName = By.cssSelector(FULLNAME_FIELD);
  static By email = By.cssSelector(email_FIELD);
  static By currentAddress = By.cssSelector(currentAddress_FIELD);
  static By permAddress = By.cssSelector(permanentAddress_FIELD);
  static By submit = By.xpath(submit_BUTTON);
  static By expand = By.xpath(expand_BUTTON);
  static By selectedOption = By.xpath(SELECTED_OPTION);
  static By homeLink = By.linkText(HOMELINK);
  static By createdLink = By.linkText(CREATEDLINK);
  static By validLink = By.partialLinkText(PARTIALLINKRESPONSE);




    // Launches the site in defined browser
    public void launchUrl(String urlPage) throws WebDriverException {

        driver.get((dataLoadingUtil.fetchConfigValue("url")+urlPage));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

    }

    // this is to provide login details
    public void provideLoginDetails(String userName_val, String password_Val){
           helper.waitForVisibilityOfElement(userName);
        try {
            driver.findElement(userName).sendKeys(userName_val);
            helper.sendKeys(password,password_Val);
        } catch (ElementNotInteractableException e) {
            throw e;
        }
    }

    public void clickLoginButton(){
        helper.click(login);
    }
    public void clickSubemitButton(){
        helper.waitForVisibilityOfElement(submit);
        helper.scrollDown(20);
        helper.click(submit);
    }

    public void validateUserIsInProfilelPage(){
        System.out.println(driver.findElement(afterLoginPath).getText());

    }


    public void userFillsINFormDetail(){
        helper.sendKeys(fullName, dataLoadingUtil.fetchConfigValue("fullName"));
        helper.sendKeys(email, dataLoadingUtil.fetchConfigValue("Email"));
        helper.sendKeys(currentAddress, dataLoadingUtil.fetchConfigValue("current_Address"));
        helper.sendKeys(permAddress, dataLoadingUtil.fetchConfigValue("perm_Address"));
    }

    public void expandtheList(){
        List<WebElement> expandiconList = driver.findElements(expand);
        for(int i=0;i<expandiconList.size();i++){
            expandiconList.get(i).click();
            expandiconList = driver.findElements(expand);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void enableCheckbox(){

        helper.click(desktopCheckbox);
    }


    public void clickRadioButton(String option) throws InterruptedException {
        optionProvided =option;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        switch (option) {
            case "yes":
                helper.click(yesradio);
            case "Impressive":
                helper.click(impressivradioe);
            case "no":
                helper.click(noradio);
            default:
                helper.click(yesradio);
        }
    }

    public void valdiatedSelectedOption(){
       String optionSelected =  helper.getText(selectedOption);

        Assert.assertEquals(optionSelected,optionProvided," Option selected and provided are same");
    }

    public void dbClick(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(dbClick)).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
    }

    public void rightClick(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        Actions actions = new Actions(driver);
       actions.contextClick(driver.findElement(rightClick)).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
    }

    public void validatemessage(String message){
        if(message.equalsIgnoreCase("dbClick")){
           Assert.assertEquals(helper.getText(dbCLickMessae),"You have done a double click","Values are equal");
        } else if (message.equalsIgnoreCase("rightClick")) {
            Assert.assertEquals(helper.getText(rightCLickMessage),"You have done a right click","Values are equal");
        }
    }

    public void uploadFile(){
        log.info("trying to upload a file");
        WebElement element = driver.findElement(uploadFile);
        element.sendKeys("/Users/sundareswaribala/Documents/Sundareswari-CV.docx");

    }

    public void clickLink(String link) {
        if (link.equalsIgnoreCase("Home")) {
            helper.click(homeLink);
            helper.handlesMultipleTabs();
            Assert.assertEquals(dataLoadingUtil.fetchConfigValue("url"), driver.getCurrentUrl(), "Home button is clicked");
        } else if (link.equalsIgnoreCase("dynamic")) {
            helper.click(dynamicLink);
            helper.handlesMultipleTabs();
            Assert.assertEquals(dataLoadingUtil.fetchConfigValue("url"), driver.getCurrentUrl(), "Home button is clicked");
        } else if (link.equalsIgnoreCase("createdLink")) {
            helper.click(createdLink);
            System.out.println(helper.getText(linkresponse));
        } else if (link.equalsIgnoreCase("ValidLink")) {
            System.out.println(driver.findElement(validLink).getAttribute("href"));
            helper.click(validLink);
            Assert.assertEquals(dataLoadingUtil.fetchConfigValue("url"), driver.getCurrentUrl(), "Home button is clicked");

        }


    }
}
