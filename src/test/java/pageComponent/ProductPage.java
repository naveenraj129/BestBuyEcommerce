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

    @FindBy(xpath = "//a[contains(text(),'Lenovo - ThinkBook 16 G6 ABP (AMD) in 16\" Touch-screen Notebook - AMD Ryzen 7 with 16GB Memory - 512GB SSD - Gray')]")
    WebElement lenovoThinkPadTitleAtProductPage;

    @FindBy(xpath = "//h4[@class = 'sku-title']//a[text() = 'Sony - 75\" Class X85K LED 4K UHD Smart Google TV - (2023)']")
    WebElement sonyTvTitleAtProductPage;

    public ProductPage() {

        PageFactory.initElements(driver, this);
    }

    public String addKeyBoard() throws InterruptedException {
        String TitleAtProductPage = extractText(keyBoardTitleAtProductPage);
        Thread.sleep(4000);
        jsClickOn(addToCartButtons.get(0),10);
        return TitleAtProductPage;
    }

    public void continueShopButtton() throws InterruptedException {
        Thread.sleep(3000);
        jsClickOn(continueShopButtton , 15);
    }

    public String addSonyTv() throws InterruptedException {
        String TitleAtProductPage = extractText(sonyTvTitleAtProductPage);
        waitExplicit(addToCartButtons.get(0), 15);
        Thread.sleep(2000);
        eleClick(addToCartButtons.get(0), 15);
        return TitleAtProductPage;
    }

    public String addLenovoThinkPad() {
        eleClick(thinkPadLaptopsAtLenovoProdPage, 15);
        String TitleAtProdPage = extractText(lenovoThinkPadTitleAtProductPage);
        eleClick(addToCartButtons.get(0), 15);
        return TitleAtProdPage;
    }


}
