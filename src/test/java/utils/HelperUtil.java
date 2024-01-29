package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HelperUtil{

    WebDriver driver ;

    public HelperUtil(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * this method will make the method wait for element to be visible
     */

    public void waitForVisibilityOfElement(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    /**
     * this method will make the method wait for defined seconds
     */

    public void getImplicitlyWait() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("waiting for " + 30 + " sec");

    }

    /**
     * this method will make random number generator
     */
    public int randomNumberGenerator(){
        Random random = new Random();

        int rand = Math.abs(random.nextInt());

        return rand;
    }


    /**
     * this method will validate title
     */
    public void validateTitle(String title){
        String titleFromApp = driver.getTitle();
        Assert.assertEquals("title is valid", titleFromApp, title);
    }

    /**
     * this method will click element in webpage
     */
    public void click(By element){
        driver.findElement(element).click();
    }


    /**
     * this method will send keys to the input field
     */
    public void sendKeys(By element,String text){
        driver.findElement(element).sendKeys(text);
    }

    /**
     * this method will validate two text are equal
     */

    public void assertEquals(int actual, int expected) {
        Assert.assertEquals(actual, expected);

    }

    /**
     * this method will handle multiple windows
     */

    public void handlesMultipleTabs(){
        Set<String> tabs =  driver.getWindowHandles();
        Iterator<String> I1= tabs.iterator();
        while(I1.hasNext()) {
            String child_window = I1.next();
            driver.switchTo().window(child_window);
        }
    }

    /**
     * this method will validate two different text
     */
    public void compare_twoDifferentText(String text1, String text2){
        if(!text1.equals(text2)){
            System.out.println("Texts are not equal");
        }else{
            Assert.assertFalse(text1.equals(text2),"Search isn't filtering the results");
        }
    }

    /**
     * this method will validate first text contains second text
     */

    public void assertContainsValue(String actual, String expected) {

        boolean compare_result = expected.contains(actual);
        Assert.assertTrue(compare_result );

    }

    /**
     * this method will navigate back to previous page
     */
    public void deviceBack() {
        driver.navigate().back();
    }

    /**
     * this method will navigate refresh the page
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * @param element
     * @return this method will return text from the web element
     */
    public String getText(By element) {

        waitForVisibilityOfElement(element);
        String text_Val = driver.findElement((element)).getText();
        //System.out.println("Text value inside header is " + text_Val);
        if (text_Val != null) {
            return text_Val;
        } else {
            throw new RuntimeException("Text value from screen is empty");

        }
    }

    /**
     * this method will select a value from drop down
     */
    public void selectvaluesFromDropdown(By element1,String value) {


        Select select_fromdrpdown = new Select(driver.findElement(element1));
        select_fromdrpdown.selectByValue(value);

    }


    /**
     * this method is used to dismiss the alert
     */
    public void alertManager(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            driver.switchTo().alert().sendKeys("");
            driver.switchTo().alert().dismiss();

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * this method is to hover over the element
     */

    public void hoverOverElement(By element1, By element2) {

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(element1);
        action.moveToElement(we).moveToElement(driver.findElement(element2)).click().build().perform();

    }

    /**
     * this method will scroll down the page
     */

    public void scrollDown(int scroll_Val) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + scroll_Val + ")");
    }

    public void scrollUp(int scroll_Val) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(" + scroll_Val +", 0)");
    }

    /**
     * this method will scroll down the page until a particular element
     */

    public void scrollUntilElementVisible(By element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(element);
        jse.executeScript("arguments[0].scrollIntoView();", Element);

    }


    /**
     * this method will scroll down to bottom of the page
     */

    public void scrollTotheBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }



}
