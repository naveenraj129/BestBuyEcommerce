package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.CreateAccountPage;
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
    public void tc_03_validateCreateAccountFunctionality(String fname, String lname, String emailId, String pass, String repass, String mob, String TextXpath, String expMsg) {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreateAccountPage cp = new CreateAccountPage();
        String actMsg = cp.createAccountFunctionality(fname, lname, emailId, pass, repass, mob, TextXpath);
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }

    @Test
    public void tc_03_validateSuccessCreateAccountFunctionality() {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreateAccountPage cp = new CreateAccountPage();
        String actMsg = cp.createAccountSuccessFunctionality();
        String error1 = "Sorry, there was a problem creating your account. Please review your info and try again.";
        String error2 = "An account with this email already exists. Please sign in or use a different email address.";

        String normalizedActMsg = actMsg.replaceAll("\\s+", " ").trim();
        Assert.assertTrue(normalizedActMsg.equals(error1) || normalizedActMsg.equals(error2));

        if (normalizedActMsg.equals(error1) || normalizedActMsg.equals(error2)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }

}
