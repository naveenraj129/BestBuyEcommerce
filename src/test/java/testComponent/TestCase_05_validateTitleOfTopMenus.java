package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;
import pageComponent.LocationPage;

public class TestCase_05_validateTitleOfTopMenus extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_05_validateTitleOfTopMenus";
        testDescription = "Check the different menu titles";
        testCategory = "Regression";
        sheetName = "TopMenuData";
    }


    @Test(dataProvider = "getFromExcel", priority = 5)
    public void tc_05_validateTitleOfTopMenus(String menuName, String expTitle)  {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        String actTitle = hp.topMenusValidation(menuName);
        softAssert(actTitle, expTitle);
        if (actTitle.equals(expTitle)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }
}

