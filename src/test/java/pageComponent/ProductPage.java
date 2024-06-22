package pageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;

import java.util.List;

public class ProductPage extends WebUtility {

    @FindBy(xpath = "//a[text()='CORSAIR - K70 CORE RGB Mechanical Gaming Keyboard - Gray']")
    WebElement keyBoardTitleAtProductPage;

    @FindBy(xpath = "//button[text() = 'Add to Cart']")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//button[text() = 'Continue shopping']")
    WebElement continueShopButtton;

    @FindBy(xpath = "//p[text()='ThinkPad laptops']")
    WebElement thinkPadLaptopsAtLenovoProdPage;

    @FindBy(xpath = "//a[contains(text(),'Lenovo - ThinkPad E14 Gen 5 14\" Touch-Screen Laptop - i5-1335U with 16GB Memory - 512GB SSD - Black')]")
    WebElement lenovoThinkPadTitleAtProductPage;

    @FindBy(xpath = "//button[@data-button-state='ADD_TO_CART']")
    WebElement addToCartLenovoThinkPad;

    @FindBy(xpath = "//a[text() ='Sony - 65\" Class BRAVIA XR A80L OLED 4K UHD Smart Google TV']")
    WebElement sonyTvTitleAtProductPage;

    @FindBy(xpath = "//button[@data-button-state='ADD_TO_CART']")
    WebElement addToCartSonyTv;

    public ProductPage() {

        PageFactory.initElements(driver, this);
    }

    public String addKeyBoard() throws Exception {
        String TitleAtProductPage = extractText(keyBoardTitleAtProductPage);
        waitExplicit(addToCartButtons.get(0), 15);
        Thread.sleep(3000);
        elementClick(addToCartButtons.get(0));
//        elementClick(addToCartButtons.get(0));
        return TitleAtProductPage;
    }

    public void ContinueShopButtton() {
        waitExplicit(continueShopButtton, 15);
        jsClickOn(continueShopButtton, 15);
    }


    public String addSonyTv() {
        String TitleAtProductPage = extractText(sonyTvTitleAtProductPage);
        eleClick(addToCartSonyTv, 15);
        return TitleAtProductPage;
    }

    public String addLenovoThinkPad() {
        eleClick(thinkPadLaptopsAtLenovoProdPage, 15);
        String TitleAtProdPage = extractText(lenovoThinkPadTitleAtProductPage);
        jsClickOn(addToCartLenovoThinkPad, 15);
        return TitleAtProdPage;
    }


}
