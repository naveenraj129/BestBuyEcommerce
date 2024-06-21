package TestComponent;

import EngineComponent.BaseClass;
import PageComponent.LocationPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class testCase01_navigatingToBestBuy extends BaseClass {

    @Test
    public void testCase1() throws InterruptedException {
        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        String actText = lp.getPageTitle();
        System.out.println(actText);
        String expText = "Best Buy International: Select your Country - Best Buy";
        softAssert(actText , expText);

        if(actText.equals(expText)){
            test.log(Status.PASS , "testcase1 is passed");
        }else{
            test.log(Status.FAIL , "testcase1 is failed");
        }
    }

}
