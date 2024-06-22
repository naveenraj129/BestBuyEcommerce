package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.CreteAccountPage;
import pageComponent.HomePage;
import pageComponent.LocationPage;

public class TestCase_03_validateCreateAccountFunctionality extends BaseClass {
    @BeforeTest
    public void setup() {
        testName = "tc_03_validateCreateAccountFunctionality";
        testDescription = "CreatAccount Functionality";
        testCategory = "Regression";
        sheetName = "CreateAccountData";
    }

    @Test(dataProvider = "getFromExcel", priority = 3)
    public void tc_03_validateCreateAccountFunctionality(String fname, String lname, String emailId,
                                                         String pass, String repass, String mob, String xpathText, String expMsg) throws Exception {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreteAccountPage cp = new CreteAccountPage();
        String actMsg = cp.createAccountFunctionality(fname, lname, emailId, pass, repass, mob, xpathText);
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }
}
