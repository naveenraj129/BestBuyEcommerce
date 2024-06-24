package testComponent;

import engineComponent.BaseClass;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_06_validateBottomLinks extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_06_validateLinkInBottomOfHomePage";
        testDescription = "Validating Link in Homepage Bottom";
        testCategory = "Regression";
        sheetName = "BottomMenuData";
    }
    @Test(dataProvider="getFromExcel")
    public void tc_06_validateLinkInBottomOfHomePage(String menuName,String expTitle) throws Exception {
        LocationPage lp=new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp=new HomePage();
        String actTitle = hp.bottomMenusValidation(menuName);
        softAssert(actTitle, expTitle);
        if (actTitle.equals(expTitle)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }


}
