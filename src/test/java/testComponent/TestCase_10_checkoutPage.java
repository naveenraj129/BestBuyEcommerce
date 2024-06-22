package testComponent;

import engineComponent.BaseClass;
import pageComponent.*;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TestCase_10_checkoutPage extends BaseClass {
    @Test(priority = 10)
    public void tc_10_CheckOutPageFilling() throws Exception {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.searchProduct("keyboard");
        ProductPage pp = new ProductPage();
        pp.addKeyBoard();
        pp.ContinueShopButtton();
        hp.cartButton();
        CartPage cp = new CartPage();
        cp.goToCheckOutPage();
        CheckOutPage cop = new CheckOutPage();
        cop.continueAsGuestButton();
        cop.contactInfoAtCheckOut();
       // cop.enterAddressOnCheckOut();
        String actText = cop.enterAddressOnCheckOut();
        String expText = "Request failed because of network connection";

        softAssert(actText, expText);
        if (actText.equals(expText)) {
            test.log(Status.PASS, "Checkout Functionality passed");
        } else {
            test.log(Status.FAIL, "Checkout Functionality Failed");
        }
    }
}
