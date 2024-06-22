package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;
import pageComponent.LocationPage;

public class TestCase_05_validateAllMenus extends BaseClass {

    @BeforeTest
    public void setup() {
        sheetName = "sheet1";
    }


    @Test(dataProvider = "getFromExcel", priority = 5)
    public void testcase1(String menuName, String expTitle) {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        String actTitle = hp.topMenusValidation(menuName);
        softAssert(actTitle, expTitle);
        if (actTitle.equals(expTitle)) {
            test.log(Status.PASS, "ValidatingMenusFunctionality passed");
        } else {
            test.log(Status.FAIL, "ValidatingMenusFunctionality Failed");
        }
    }
}

