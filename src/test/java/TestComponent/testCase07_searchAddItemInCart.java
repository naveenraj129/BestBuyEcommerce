package TestComponent;

import EngineComponent.BaseClass;
import PageComponent.CartPage;
import PageComponent.HomePage;
import PageComponent.LocationPage;
import PageComponent.ProductPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testCase07_searchAddItemInCart extends BaseClass {

    @Test
    public void testCase1() throws Exception {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.searchProduct("keyboard");
        ProductPage pp = new ProductPage();
        String TitleAtProductPage = pp.addKeyBoard();
        CartPage cp = new CartPage();
        String TitleAtCartPage = cp.validateKeyboardInCart();
        softAssert(TitleAtProductPage , TitleAtCartPage);
        if (TitleAtProductPage.equals(TitleAtCartPage)) {
            test.log(Status.PASS , "SearchAddItemInCart functionality is passed");
        } else {
            test.log(Status.FAIL , "SearchAddItemInCart functionality is Failed");
        }
    }
}
