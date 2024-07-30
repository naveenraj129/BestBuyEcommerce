package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;


public class GeneralUtility {

    public static ExtentReports report;
    public static ExtentTest test;
    public static String sheetName;
    public String testName;
    public String testDescription;
    public String testCategory;
    static String urlToCheck = "https://www.bestbuy.com/";


    public static void reportInit() {
        ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/report1.html");
        report = new ExtentReports();
        report.attachReporter(html);
    }

    public static void softAssert(String actResult, String expResult) {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(actResult, expResult);
    }

    public static boolean isLinkBroken() throws IOException {
        URL url = new URL(urlToCheck);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//        httpURLConnection.setRequestMethod("HEADLESS");
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        return (responseCode >= 400);
    }

    public static Object[][] dataReader(String sheetName) throws IOException {
        String excelPath = "/Users/evanjalinmuthuraj/Documents/seleniumproject/BestBuyEcommerce/src/test/resources/BestBuyEcommerce.xlsx";
        FileInputStream excelFile = new FileInputStream(excelPath);
        XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workBook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        excelFile.close();
        return data;
    }


}
