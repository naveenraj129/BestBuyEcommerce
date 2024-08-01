package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.CartPage;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import pageComponent.ProductPage;

public class TestCase_08_SelectAddItemByMenuDept extends BaseClass {


    @BeforeTest
    public void setup() {

        testName = "tc_08_selectAddItemByMenuDept";
        testDescription = "Search a Item by Department in Menu and add it in cart";
        testCategory = "Regression";
    }

    @Test
    public void tc_08_selectAddItemByMenuDept() throws InterruptedException {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        HomePage hp = new HomePage();
        hp.openMenu();
        hp.selectShopByDepartment();
        ProductPage pp = new ProductPage();
        String TitleAtProductPage = pp.addSonyTv();
        CartPage cp = new CartPage();
        String TitleAtCartPage = cp.validateSonyTvInCart();
        softAssert(TitleAtProductPage, TitleAtCartPage);
        if (TitleAtProductPage.equals(TitleAtCartPage)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.PASS, testName + " - Failed");
        }
    }
}
