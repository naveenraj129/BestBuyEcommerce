package testComponent;

import engineComponent.BaseClass;
import pageComponent.CartPage;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import pageComponent.ProductPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TestCase_08_selectMenuByDepartment extends BaseClass {

    @Test
    public void testCase1() throws Exception {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.openMenu();
       hp.selectShopByDepartment();
        ProductPage pp = new ProductPage();
        String TitleAtProductPage = pp.addSonyTv();
        CartPage cp = new CartPage();
        String TitleAtCartPage = cp.validateSonyTvInCart();
        softAssert(TitleAtProductPage , TitleAtCartPage);
        if (TitleAtProductPage.equals(TitleAtCartPage)) {
            test.log(Status.PASS , "SelectMenuByDepartment functionality is passed");
        } else {
            test.log(Status.FAIL , "SelectMenuByDepartment functionality is Failed");
        }
    }
}
