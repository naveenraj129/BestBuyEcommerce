package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;
import pageComponent.LocationPage;

public class TestCase_06_ValidateBottomLinks extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_06_validateLinkInBottomOfHomePage";
        testDescription = "Validating Link in Homepage Bottom";
        testCategory = "Regression";
        sheetName = "BottomMenuData";
    }

    @Test(dataProvider = "getFromExcel")
    public void tc_06_validateLinkInBottomOfHomePage(String menuName, String expTitle) {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        HomePage hp = new HomePage();
        String actTitle = hp.bottomMenusValidation(menuName);
        softAssert(actTitle, expTitle);
        if (actTitle.equals(expTitle)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }


}
