package testComponent;

import engineComponent.BaseClass;
import pageComponent.HomePage;
import pageComponent.LocationPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_06_validateBottomLinks extends BaseClass {

    @BeforeTest
    public void setup() {
        sheetName="sheet2";
    }

    @Test(dataProvider="getFromExcel")
    public void testcase1(String menuName,String expTitle) throws Exception {
        LocationPage lp=new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp=new HomePage();
        String actTitle = hp.bottomMenusValidation(menuName);
        softAssert(actTitle, expTitle);
        if (actTitle.equals(expTitle)) {
            test.log(Status.PASS , "ValidatingBottomMenusFunctionality passed");
        } else {
            test.log(Status.FAIL , "ValidatingBottomMenusFunctionality Failed");
        }
    }


}
