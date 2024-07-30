package pageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;

public class CartPage extends WebUtility {

    @FindBy(xpath = "//a[contains(text(),'CORSAIR - K70 CORE RGB Mechanical Gaming Keyboard - Gray')]")
    WebElement keyBoardTitleAtCart;

    @FindBy(xpath = "//a[contains(text(),'Lenovo - ThinkBook 16 G6 ABP (AMD) in 16\" Touch-screen Notebook - AMD Ryzen 7 with 16GB Memory - 512GB SSD - Gray')]")
    WebElement lenovoThinkPadAddedInCart;

    @FindBy(xpath = "//h4[@class = 'sku-title']//a[text() = 'Sony - 75\" Class X85K LED 4K UHD Smart Google TV - (2023)']")
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
        explicitWait(checkOutButton, 15);
        Thread.sleep(5000);
        elementClick(checkOutButton);
    }

}

