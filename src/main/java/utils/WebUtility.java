package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebUtility extends GeneralUtility {

    public static WebDriver driver;

    public static String readProperty(String key) throws Exception {
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "/BestBuyApplication.properties");
        FileInputStream fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        return prop.get(key).toString();
    }

    public static void openBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options=new FirefoxOptions();
//            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Opening Chrome browser as Default browser");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        waitImplicit();
    }

    public static void openWebsite(String url) {
        driver.get(url);
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

    public void SurveyWindow() throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement surveyWindow = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("survey-window")));
            // If survey window is found, close it
            if (surveyWindow.isDisplayed()) {
                surveyWindow.findElement(By.cssSelector("button.close")).click();  // Adjust the selector to the actual close button
                System.out.println("Survey window closed.");
            }
        } catch (NoSuchElementException e) {
            // Survey window not found, continue with the test
            System.out.println("Survey window not present.");
        }
    }

}
