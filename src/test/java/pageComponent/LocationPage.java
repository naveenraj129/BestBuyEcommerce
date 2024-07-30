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
        eleClick(countryUSA, 15);
    }

    public void deliveryAtCanada() {

        eleClick(countryCanada, 15);

    }

    public String getPageTitle() {
        return title;
    }

    public boolean urlResponseCode() throws Exception {
        return isLinkBroken();
    }

}
