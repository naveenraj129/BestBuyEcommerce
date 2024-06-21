package PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;


public class CartPage extends WebUtility {

    @FindBy(xpath = "//a[contains(text(),'CORSAIR - K70 CORE RGB Mechanical Gaming Keyboard - Gray')]")
    WebElement keyBoardTitleAtCart;

    @FindBy(xpath = "//a[contains(text(),'Lenovo - ThinkPad E14 Gen 5 14\" Touch-Screen Laptop - i5-1335U with 16GB Memory - 512GB SSD - Black')]")
    WebElement lenovoThinkPadAddedInCart;

    @FindBy(xpath = "//a[text() = 'Sony - 65\" Class BRAVIA XR A80L OLED 4K UHD Smart Google TV']")
    WebElement sonyTvTitleAtCart;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkOutButton;

    public CartPage() {

        PageFactory.initElements(driver, this);
    }

    public String validateKeyboardInCart() {
        return extractText(keyBoardTitleAtCart);
    }

    public String validateSonyTvInCart() {
        return extractText(sonyTvTitleAtCart);
    }

    public String validateLenovoThinkPadInCart() {
        return extractText(lenovoThinkPadAddedInCart);
    }

    public void goToCheckOutPage() throws InterruptedException {
        waitExplicit(checkOutButton, 15);
        Thread.sleep(5000);
        elementClick(checkOutButton);
    }

}

