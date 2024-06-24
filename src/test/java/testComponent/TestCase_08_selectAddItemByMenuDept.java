package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import pageComponent.CartPage;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import pageComponent.ProductPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TestCase_08_selectAddItemByMenuDept extends BaseClass {


    @BeforeTest
    public void setup() {

        testName = "tc_08_selectAddItemByMenuDept";
        testDescription = "Search a Item by Department in Menu and add it in cart";
        testCategory = "Regression";
    }
    @Test
    public void tc_08_selectAddItemByMenuDept() throws Exception {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp = new HomePage();
        hp.openMenu();
       hp.selectShopByDepartment();
        ProductPage pp = new ProductPage();
        String TitleAtProductPage = pp.addSonyTv();
        System.out.println(TitleAtProductPage);
        CartPage cp = new CartPage();
        String TitleAtCartPage = cp.validateSonyTvInCart();
        System.out.println(TitleAtCartPage);
        softAssert(TitleAtProductPage , TitleAtCartPage);
        if (TitleAtProductPage.equals(TitleAtCartPage)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.PASS, testName + " - Failed");
        }
    }
}
