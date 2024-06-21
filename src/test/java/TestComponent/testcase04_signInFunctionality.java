package TestComponent;

import EngineComponent.BaseClass;
import PageComponent.HomePage;
import PageComponent.LocationPage;
import PageComponent.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.GeneralUtility.softAssert;
import static utils.GeneralUtility.test;

public class testcase04_signInFunctionality extends BaseClass {

    @Test
    public void testCase03() throws InterruptedException {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToSignIn();
    }


    @Test
    public void testCase01() throws InterruptedException {

        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.goToSignIn();
        LoginPage ln = new LoginPage();
        ln.correctCredentials();
//        ln.skipPage();

//        String actText = hp.signIn();
//        System.out.println(actText);
//        String expText = "Hi, Naveen";
//        softAssert(actText, expText);
//        if (actText.equals(expText)) {
//            test.log(Status.PASS, "testcase is passed");
//        } else {
//            test.log(Status.PASS, "testcase is Failed");
//        }
//        hp.signOut();
    }



//    @Test
//    public void testCase02() {
//
//
//        HomePage hp = new HomePage();
//        hp.goToSignIn();
//        LoginPage ln = new LoginPage();
//        ln.invalidMailId();
//        String actText = ln.invalidMailId();
//        System.out.println(actText);
//        String expText = "Oops! The email or password did not match our records. Please try again.";
//        softAssert(actText, expText);
//        if (actText.equals(expText)) {
//            test.log(Status.PASS, "testcase is passed");
//        } else {
//            test.log(Status.PASS, "testcase is Failed");
//        }
//    }
//
//    @Test
//    public void testCase03() {
//
//        HomePage hp = new HomePage();
//        hp.goToSignIn();
//        LoginPage ln = new LoginPage();
//        ln.invalidPassword();
//        String actText = ln.invalidPassword();
//        System.out.println(actText);
//        String expText = "Oops! The email or password did not match our records. Please try again.";
//        softAssert(actText, expText);
//        if (actText.equals(expText)) {
//            test.log(Status.PASS, "testcase is passed");
//        } else {
//            test.log(Status.PASS, "testcase is Failed");
//        }
//    }
}
