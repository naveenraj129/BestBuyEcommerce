package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;


public class HomePage extends WebUtility {


    @FindBy(xpath = "//span[text()='Account']")
    WebElement account;

    @FindBy(xpath = "//a[text()='Create Account']")
    WebElement createAccount;

    @FindBy(xpath = "//a[text()='Sign In']")
    WebElement signInButton;

    @FindBy(xpath = "//button[text() = 'Sign out']")
    WebElement signOutButton;

    @FindBy(xpath = "//span[text() = 'Hi, Naveen']")
    WebElement signInSuccessful;

    @FindBy(xpath = "//button[text() ='Menu']")
    WebElement menuButton;

    @FindBy(xpath = "//button[text() ='TV & Home Theater']")
    WebElement tvInMenu;

    @FindBy(xpath = "//button[text()='TVs by Brand']")
    WebElement tvsByBrandInnerMenu1;

    @FindBy(xpath = "//a[text()='Sony TVs']")
    WebElement sonyTvsInnerMenu2;


    @FindBy(xpath = "//button[text()='Brands']")
    WebElement brandsInMenu;

    @FindBy(xpath = "//a[text()='Lenovo']")
    WebElement LenovoInBrandsMenu;

    @FindBy(xpath = "//input[@class ='search-input']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@title='submit search']")
    WebElement searchButton;

    @FindBy(xpath = "//span[text()='Cart']")
    WebElement cartButton;


    public HomePage() {

        PageFactory.initElements(driver, this);
    }


    public void goToCreateAccount() {
        jsClickOn(account, 10);
        jsClickOn(createAccount, 10);
    }

    public void goToSignIn() {
        eleClick(account, 10);
        eleClick(signInButton, 10);
    }

    public void cartButton() {
        explicitWait(cartButton, 15);
        waitExplicit(cartButton, 15);
        jsClickOn(cartButton, 15);
    }

    public void signOut() {
        eleClick(signOutButton, 15);
    }

    public String signIn() {
        return signInSuccessful.getText();
    }

    public String topMenusValidation(String menuName) {
        jsClickOn(driver.findElement(By.xpath("//a[text()='" + menuName + "']")), 15);
        String actTitle = getTitleOfMenus();
        return actTitle;
    }

    public String bottomMenusValidation(String menuName) {
        jsClickOn(driver.findElement(By.xpath("//a[text()='" + menuName + "']")), 15);
        String actTitle = getTitleOfMenus();
        return actTitle;
    }

    public void searchProduct(String productName) {
        typeText(searchBox, productName);
        jsClickOn(searchButton, 15);
    }

    public void openMenu() {
        elementClick(menuButton);
    }

    public void selectShopByDepartment() throws InterruptedException {
        waitExplicit(tvInMenu, 20);
        elementClick(tvInMenu);
        elementClick(tvsByBrandInnerMenu1);
        elementClick(sonyTvsInnerMenu2);
    }

    public void selectByBrand() {
        waitExplicit(brandsInMenu, 20);
        jsClickOn(brandsInMenu, 15);
        eleClick(LenovoInBrandsMenu, 15);

    }

    public void goToCartPage() {
        jsClickOn(cartButton, 15);
    }

}


