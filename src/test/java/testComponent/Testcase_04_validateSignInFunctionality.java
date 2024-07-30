package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import pageComponent.LoginPage;

public class Testcase_04_validateSignInFunctionality extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_04_SignInFunctionality";
        testDescription = "Sign-In Functionality";
        testCategory = "Regression";
        sheetName = "SignInTestData";
    }

    @Test(dataProvider = "getFromExcel", priority = 4)
    public void tc_04_SignInFunctionality(String email, String password, String xpath, String expMsg) throws Exception {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToSignIn();
        LoginPage ln = new LoginPage();
        String actMsg = ln.validateSignInPage(email, password, xpath);
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.PASS, testName + " - Failed");
        }
    }


}
