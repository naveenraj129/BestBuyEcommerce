package pageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WebUtility.*;

public class CheckOutPage {


    @FindBy(id = "fld-e")
    WebElement emailToSignInAtCheckOut;

    @FindBy(id = "fld-p1")
    WebElement passToSignInAtCheckOut;

    @FindBy(xpath = "//button[text()='Sign In']")
    WebElement sigInButtonAtCheckOutPage;

    @FindBy(xpath = "//button[text()='Continue as Guest']")
    WebElement continueAsGuestButton;

    @FindBy(id = "user.emailAddress")
    WebElement emailInputElementAtCheckOutPage;

    @FindBy(id = "user.phone")
    WebElement mobileNumInputElementAtCheckOutPage;

    @FindBy(xpath = "//input[@id='text-updates']")
    WebElement textUpdateCheckBox;

    @FindBy(xpath = "//span[text()='Continue to Payment Information']")
    WebElement continueToPayement;

    @FindBy(xpath = "//div[contains(@class,'error-spacing')]")
    WebElement errorText;

    @FindBy(xpath = "//input[@id='number']")
    WebElement debitCardNumber;

    @FindBy(id = "expMonth")
    WebElement expMonth;

    @FindBy(id = "expYear")
    WebElement expYear;

    @FindBy(id = "cvv")
    WebElement cvv;

    @FindBy(xpath = "//button[@id = 'changeFullfilmentButton']")
    WebElement switchToShippingButton;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;


    @FindBy(xpath = "//input[@aria-labelledby='last-name-help']")
    WebElement lastName;

    @FindBy(xpath = "//input[@aria-controls='suggestionsMenuId']")
    WebElement address;

    @FindBy(xpath = "//input[@aria-labelledby='city-help']")
    WebElement city;

    @FindBy(xpath = "//select[@id='state']")
    WebElement state;

    @FindBy(xpath = "//input[@aria-labelledby='zipcode-help']")
    WebElement postalCode;

    @FindBy(xpath = "//button[contains(@class , 'button-md new-address-form__button')]")
    WebElement applyButton;

    @FindBy(xpath = "//span[text()='Keep Address as Entered']")
    WebElement enteredAddress;

    @FindBy(xpath = "//span[text()='Place Your Order']")
    WebElement placeYourOrder;

    public CheckOutPage() {
        PageFactory.initElements(driver, this);
    }

    public void contactInfoAtCheckOut() {
        typeText(emailInputElementAtCheckOutPage, "naveenrajv129@gmail.com");
        typeText(mobileNumInputElementAtCheckOutPage, "9066543213");
        eleClick(textUpdateCheckBox, 15);
//        eleClick(continueToPayement, 15);
    }

    public void continueAsGuestButton() {
        explicitWait(continueAsGuestButton, 15);
        eleClick(continueAsGuestButton, 15);
    }

    public String enterAddressOnCheckOut() throws InterruptedException {
        eleClick(switchToShippingButton , 15);
        Thread.sleep(2000);
        jsClickOn(firstName , 10);
        typeText(firstName, "Naveen");
        typeText(lastName, "Raj");
        typeText(address, "N Calle 11");
        typeText(city, "silverspring");
        elementClick(state);
        selectFromDropDown(state, "DC");
        typeText(postalCode, "00646");
        explicitWait(applyButton, 15);
        jsClickOn(applyButton, 15);
        explicitWait(errorText, 25);
        return errorText.getText();

    }

    public void enterDetailsOnCheckOut() throws Exception {
        typeText(debitCardNumber, "12345678");
        selectFromDropDown(expMonth, "06");
        selectFromDropDown(expYear, "2025");
        typeText(cvv, "126");
    }

    public void signInAtCheckOut() {
        typeText(emailToSignInAtCheckOut, "naveenrajv129@gmail.com");
        typeText(passToSignInAtCheckOut, "EVANaura@129");
        eleClick(sigInButtonAtCheckOutPage, 15);
        typeText(emailInputElementAtCheckOutPage, "naveenrajv129@gmail.com");
        typeText(mobileNumInputElementAtCheckOutPage, "8778335842");
        eleClick(textUpdateCheckBox, 15);

    }

}
