package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.LocationPage;

public class TestCase_01_navigatingToBestBuyWebsite extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_01_navigatingToBestBuyWebsite";
        testDescription = "Navigating to the Best Buy e-commerce website";
        testCategory = "Regression";

    }

    @Test(priority = 1)
    public void tc_01_navigatingToBestBuyWebsite() {
        LocationPage lp = new LocationPage();
        lp.selectDeliveryAtUSA();
        String actText = lp.getPageTitle();
        String expText = "Best Buy International: Select your Country - Best Buy";
        softAssert(actText, expText);

        if (actText.equals(expText)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }

}
