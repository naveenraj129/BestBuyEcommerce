package TestComponent;

import EngineComponent.BaseClass;
import PageComponent.HomePage;
import PageComponent.LocationPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCase05_validatingAllMenus extends BaseClass {

    @BeforeTest
    public void setup() {
        sheetName="sheet1";
    }


    @Test(dataProvider="getFromExcel")
    public void testcase1(String menuName,String expTitle) throws Exception {
        LocationPage lp=new LocationPage();
        lp.deliveryAtUSA();
        HomePage hp=new HomePage();
        String actTitle = hp.topMenusValidation(menuName);
        softAssert(actTitle, expTitle);
        if (actTitle.equals(expTitle)) {
            test.log(Status.PASS , "ValidatingMenusFunctionality passed");
        } else {
            test.log(Status.FAIL , "ValidatingMenusFunctionality Failed");
        }
    }
}

