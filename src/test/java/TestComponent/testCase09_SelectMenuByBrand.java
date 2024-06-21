package TestComponent;

import EngineComponent.BaseClass;
import PageComponent.CartPage;
import PageComponent.HomePage;
import PageComponent.LocationPage;
import PageComponent.ProductPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import static utils.GeneralUtility.softAssert;
import static utils.GeneralUtility.test;

public class testCase09_SelectMenuByBrand extends BaseClass {


    @Test
    public void testCase1() throws Exception {
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
            test.log(Status.PASS , "SelectMenuByBrand functionality is passed");
        } else {
            test.log(Status.FAIL , "SelectMenuByBrand functionality is Failed");
        }
    }
}
