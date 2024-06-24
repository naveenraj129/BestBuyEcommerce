package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import pageComponent.CartPage;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import pageComponent.ProductPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TestCase_09_selectAddItemByMenuBrand extends BaseClass {
    @BeforeTest
    public void setup() {

        testName = "tc_09_selectAddItemByMenuBrand";
        testDescription = "Search a Item by Brands in Menu and add it in cart";
        testCategory = "Regression";
    }

    @Test
    public void tc_09_selectAddItemByMenuBrand() throws Exception {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.openMenu();
        hp.selectByBrand();
        ProductPage pp = new ProductPage();
        String TitleAtProductPage = pp.addLenovoThinkPad();
        CartPage cp = new CartPage();
        String TitleAtCartPage = cp.validateLenovoThinkPadInCart();
        softAssert(TitleAtProductPage , TitleAtCartPage);
        if (TitleAtProductPage.equals(TitleAtCartPage)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.PASS, testName + " - Passed");
        }
    }
}
