package TestComponent;

import EngineComponent.BaseClass;
import PageComponent.CreteAccountPage;
import PageComponent.HomePage;
import PageComponent.LocationPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class testCase03_createAccountFunctionality extends BaseClass {
    @Test
    public void testCase_01() {
        LocationPage lp=new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreteAccountPage cp = new CreteAccountPage();
        String actText = cp.accountCreated();
        System.out.println(actText);
    String expText = "Sorry, there was a problem creating your account.";

    softAssert(actText, expText);
    if(actText.equals(expText)){
        test.log(Status.PASS , "createAccountFunctionality passed");
    }else{
        test.log(Status.FAIL , "createAccountFunctionality Failed");
    }
        cp.PreviousPage();
    }

    @Test
    public void testCase_02() {
//        LocationPage lp=new LocationPage();
//        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreteAccountPage cp = new CreteAccountPage();
        String actText = cp.withoutFirstName();
        String expText = "Please enter your first name.";
        softAssert(actText, expText);
        if (actText.equals(expText)) {
            test.log(Status.PASS, "createAccountFunctionality passed");
        } else {
            test.log(Status.FAIL, "createAccountFunctionality Failed");
        }
        cp.PreviousPage();
    }

    @Test
    public void testCase_03() {
//        LocationPage lp=new LocationPage();
//        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreteAccountPage cp = new CreteAccountPage();
        String actText = cp.withoutLastName();
        String expText = "Please enter your last name.";
        softAssert(actText, expText);
        if (actText.equals(expText)) {
            test.log(Status.PASS, "TestCase passed");
        } else {
            test.log(Status.FAIL, "Testcase Failed");
        }
        cp.PreviousPage();
    }

    @Test
    public void testCase_04() {
//        LocationPage lp=new LocationPage();
//        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreteAccountPage cp = new CreteAccountPage();
        String actText = cp.withoutEmail();
        String expText = "Please enter a valid email address.";
        softAssert(actText, expText);
        if (actText.equals(expText)) {
            test.log(Status.PASS, "TestCase passed");
        } else {
            test.log(Status.FAIL, "Testcase Failed");
        }
        cp.PreviousPage();
    }

    @Test
    public void testCase_05() {
//        LocationPage lp=new LocationPage();
//        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreteAccountPage cp = new CreteAccountPage();
        String actText = cp.withoutPassword();
        String expText = "Please enter a strong password.";
        softAssert(actText, expText);
        if (actText.equals(expText)) {
            test.log(Status.PASS, "TestCase passed");
        } else {
            test.log(Status.FAIL, "Testcase Failed");
        }
        cp.PreviousPage();
    }

    @Test
    public void testCase_06() {
//        LocationPage lp=new LocationPage();
//        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreteAccountPage cp = new CreteAccountPage();
        String actText = cp.withoutConfirmPassword();
        String expText = "Passwords do not match.";
        softAssert(actText, expText);
        if (actText.equals(expText)) {
            test.log(Status.PASS, "TestCase passed");
        } else {
            test.log(Status.FAIL, "Testcase Failed");
        }
        cp.PreviousPage();
    }

    @Test
    public void testCase_07() {
//        LocationPage lp=new LocationPage();
//        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        CreteAccountPage cp = new CreteAccountPage();
        String actText = cp.withoutMobile();
        String expText = "Please enter a valid mobile phone number.";
        softAssert(actText, expText);
        if (actText.equals(expText)) {
            test.log(Status.PASS, "TestCase passed");
        } else {
            test.log(Status.FAIL, "Testcase Failed");
        }
        cp.PreviousPage();
    }
//

}
