package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.CartPage;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import pageComponent.ProductPage;

public class TestCase_07_SearchAddItemInCart extends BaseClass {

    @BeforeTest
    public void setup() {

        testName = "tc_07_SearchAddItemInCart";
        testDescription = "Search a Item in search box and add it in cart";
        testCategory = "Regression";
    }

    @Test
    public void tc_07_SearchAddItemInCart() throws Exception {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        HomePage hp = new HomePage();
        hp.searchProduct("keyboard");
        ProductPage pp = new ProductPage();
        String TitleAtProductPage = pp.addKeyBoard();
        CartPage cp = new CartPage();
        String TitleAtCartPage = cp.validateKeyboardInCart();
        softAssert(TitleAtProductPage, TitleAtCartPage);
        if (TitleAtProductPage.equals(TitleAtCartPage)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }
}
