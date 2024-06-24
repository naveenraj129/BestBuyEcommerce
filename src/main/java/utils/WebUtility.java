package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUtility extends GeneralUtility {

    public static WebDriver driver;

    public static void openBrowser() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
       waitImplicit();

    }

    public static void openWebsite() {

        driver.get("https://www.bestbuy.com/");
    }


    public static void typeText(WebElement element, String value) {

        element.sendKeys(value);

    }


    public static void selectFromDropDown(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }


    public static void elementClick(WebElement element) {

        element.click();
    }

    public static String getTitleOfMenus() {
        waitExplicitUntillTitle(driver.getTitle());
        return driver.getTitle();
    }

    public static void waitImplicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    public static void waitExplicitUntillTitle(String titleToWait) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs(titleToWait));
    }


    public static void eleClick(WebElement ele, int time) {
        explicitWait(ele, time);
        ele.click();
    }

    public static void jsScrollUntillElement(WebElement element, int time) {
        explicitWait(element, time);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void jsClickOn(WebElement element, int time) {
        explicitWait(element, time);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void explicitWait(WebElement ele, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void waitExplicit(WebElement ele, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }


    public static String extractText(WebElement element) {

        return element.getText();
    }


    public static void closeBrowser() {

        driver.quit();

    }

}
