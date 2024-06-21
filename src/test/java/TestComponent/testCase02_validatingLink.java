package TestComponent;

import EngineComponent.BaseClass;
import PageComponent.LocationPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCase02_validatingLink extends BaseClass {

@Test
    public void testCase1() throws Exception {

        LocationPage lp = new LocationPage();
        lp.deliveryAtUSA();
        boolean actResponseCode = lp.urlResponseCode();
        System.out.println(actResponseCode);
        boolean expResponseCode = false;
        Assert.assertEquals(actResponseCode , expResponseCode);

        if(actResponseCode == expResponseCode){
            test.log(Status.PASS , "testcase is passed");
        }else{
            test.log(Status.FAIL , "testcase is failed");
        }
    }
}
