package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.LocationPage;

public class TestCase_02_ValidateBestBuyWebsiteLink extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_02_validateBestBUyLink";
        testDescription = "BestBuy Website Link is broken or not";
        testCategory = "Regression";
    }

    @Test(priority = 2)
    public void tc_02_validateBestBuyLink() throws Exception {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        boolean actResponseCode = lp.urlResponseCode();
        boolean expResponseCode = false;
        Assert.assertEquals(actResponseCode, expResponseCode);

        if (actResponseCode == expResponseCode) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }
}
