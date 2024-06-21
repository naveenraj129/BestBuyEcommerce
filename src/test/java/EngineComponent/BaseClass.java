package EngineComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

import utils.WebUtility;


public class BaseClass extends WebUtility {

    @BeforeTest
    public void beforeTest() {
        reportInit();

       // openWebsite();
        System.out.println("Before test");
    }

    @AfterTest
    public void afterTest() {
       //closeBrowser();
        System.out.println("After test");
    }

    @BeforeMethod
    public void beforeMethod() {
        openBrowser();
        openWebsite();
        test = report.createTest("testCase07_searchAddItemInCart");
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        closeBrowser();
        System.out.println("After method");
        report.flush();
    }
    @DataProvider
    public Object[][] getFromExcel() throws Exception{
        Object[][] data = dataReader(sheetName);
        return data;
    }
}
