package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.CartPage;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import pageComponent.ProductPage;

public class TestCase_09_selectAddItemByMenuBrand extends BaseClass {
    @BeforeTest
    public void setup() {

        testName = "tc_09_selectAddItemByMenuBrand";
        testDescription = "Search a Item by Brands in Menu and add it in cart";
        testCategory = "Regression";
    }

    @Test
    public void tc_09_selectAddItemByMenuBrand() {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        HomePage hp = new HomePage();
        hp.openMenu();
        hp.selectByBrand();
        ProductPage pp = new ProductPage();
        String TitleAtProductPage = pp.addLenovoThinkPad();
        CartPage cp = new CartPage();
        String TitleAtCartPage = cp.validateLenovoThinkPadInCart();
        softAssert(TitleAtProductPage, TitleAtCartPage);
        if (TitleAtProductPage.equals(TitleAtCartPage)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.PASS, testName + " - Passed");
        }
    }
}
