package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;


public class HomePage extends WebUtility {

    @FindBy(xpath = "//a[text()='Top Deals']")
    WebElement topDealsMenu;

    @FindBy(xpath = "//a[text()='Deal of the Day']")
    WebElement dealsOfTheDayMenu;

    @FindBy(xpath = "//a[text()='Yes, Best Buy Sells That']")
    WebElement bestBuySellsMenu;

    @FindBy(xpath = "//span[text()='My Best Buy Memberships']")
    WebElement bestBuyMembershipMenu;

    @FindBy(xpath = "//a[text()='Credit Cards']")
    WebElement creditCardsMenu;

    @FindBy(xpath = "//a[text()='Gift Cards']")
    WebElement giftCardsMenu;

    @FindBy(xpath = "//a[text()='Yardbird']")
    WebElement yardBirdMenu;

    @FindBy(xpath = "//a[text()='Best Buy Outlet']")
    WebElement bestBuyOutletMenu;

    @FindBy(xpath = "//a[text()='Best Buy Business']")
    WebElement bestBuyBusinessMenu;

    @FindBy(xpath = "//a[text()='Shop with an Expert']")
    WebElement shopWithExpertMenu;


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

    @FindBy(xpath = "//button[@aria-label='Menu']")
    WebElement menuButton;

    @FindBy(xpath = "//button[@data-lid='ubr_tv']")
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




    @FindBy(xpath = "//a[text()='Shipping, Delivery & Pickup']")
    WebElement deliveryPickUpButton;
    @FindBy(xpath = "//a[text()='Returns & Exchanges']")
    WebElement returnsExchangesMenu;
    @FindBy(xpath = "//a[text()='Price Match Guarantee']")
    WebElement priceMatchGaurantee;
    @FindBy(xpath = "//a[text()='Trade-In Program']")
    WebElement tradeInProgramMenu;

    @FindBy(xpath = "//a[text()='My Best Buy® Credit Card']")
    WebElement bbCreditCardMenu;
    @FindBy(xpath = "//a[text()='Protection & Support Plans']")
    WebElement protectionSupportPlans;
    @FindBy(xpath = "//a[text()='Haul Away & Recycling']")
    WebElement haulAwayRecyclingMenu;
    @FindBy(xpath = "//a[text()='Developers']")
    WebElement developersMenu;
    @FindBy(xpath = "//a[text()='Best Buy Education']")
    WebElement bbEducationMenu;

    @FindBy(xpath = "//a[text()='Careers']")
    WebElement careersMenu;
    @FindBy(xpath = "//a[text()='Sustainability']")
    WebElement sustainabilityMenu;
    @FindBy(xpath = "//a[text()='Terms & Conditions']")
    WebElement termsAndConditionsMenu;
    @FindBy(xpath = "//a[text()='Privacy']")
    WebElement privacyMenu;


    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public void goToCreateAccount() {
        eleClick(account, 10);
        eleClick(createAccount, 10);

    }

    public void goToSignIn() {
        eleClick(account, 10);
        eleClick(signInButton, 10);
    }

    public void cartButton() {
        explicitWait(cartButton , 15);
        waitExplicit(cartButton , 15);
        jsClickOn(cartButton, 15);
    }

    public void signOut() {

        eleClick(signOutButton, 15);
    }

    public String signIn() throws InterruptedException {
        return signInSuccessful.getText();
    }

    public String topMenusValidation(String menuName) {
        if (menuName.equalsIgnoreCase("Shop with an Expert")) {
            elementClick(driver.findElement(By.xpath("//a[text()='" + menuName + "']")));
            String actTitle = getTitleOfMenus();
            return actTitle;
        } else {
            elementClick(driver.findElement(By.xpath("//a[text()='" + menuName + "']")));
            String actTitle = getTitleOfMenus();
            return actTitle;
        }

    }

    public String bottomMenusValidation(String menuName) {
        if (menuName.equalsIgnoreCase("Shipping, Delivery & Pickup")) {
            elementClick(driver.findElement(By.xpath("//a[text()='" + menuName + "']")));
            String actTitle = getTitleOfMenus();
            return actTitle;
        } else {
            elementClick(driver.findElement(By.xpath("//a[text()='" + menuName + "']")));
            String actTitle = getTitleOfMenus();
            return actTitle;
        }

    }

    public void searchProduct(String productName) {
        typeText(searchBox, productName);
        elementClick(searchButton);
    }

    public void openMenu() {

        eleClick(menuButton , 15);
    }

    public void selectShopByDepartment(){
        eleClick(tvInMenu , 15);
        eleClick(tvsByBrandInnerMenu1 , 15);
        eleClick(sonyTvsInnerMenu2 , 15);
    }

    public void selectByBrand(){

        eleClick(brandsInMenu , 15);
        eleClick(LenovoInBrandsMenu , 15);

    }

    public void goToCartPage() {

        eleClick(cartButton , 15);
    }

}


