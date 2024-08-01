package pageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WebUtility.*;

public class LocationPage {

    @FindBy(className = "us-link")
    WebElement countryUSA;

    @FindBy(className = "canada-link")
    WebElement countryCanada;

    String title = driver.getTitle();

    public LocationPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectDeliveryAtUSA() {
        elementClick(countryUSA);
    }

    public void deliveryAtCanada() {
        elementClick(countryCanada);
    }

    public String getPageTitle() {
        return title;
    }

    public boolean urlResponseCode() throws Exception {
        return isLinkBroken();
    }

}
