package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.*;

public class TestCase_10_CheckoutPageFilling extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_10_checkOutPageFilling";
        testDescription = "Navigating to the checkout page and filling the form with dummy payment information";
        testCategory = "Regression";
    }

    @Test(priority = 10)
    public void tc_10_checkOutPageFilling() throws Exception {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        HomePage hp = new HomePage();
        hp.searchProduct("keyboard");
        ProductPage pp = new ProductPage();
        pp.addKeyBoard();
        pp.continueShopButtton();
        hp.cartButton();
        CartPage cp = new CartPage();
        cp.goToCheckOutPage();
        CheckOutPage cop = new CheckOutPage();
        cop.continueAsGuestButton();
        cop.contactInfoAtCheckOut();
        String actText = cop.enterAddressOnCheckOut();
        String expText = "Request failed because of network connection";

        softAssert(actText, expText);
        if (actText.equals(expText)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.PASS, testName + " - Failed");
        }
    }
}
