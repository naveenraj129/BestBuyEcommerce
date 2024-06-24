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
    WebElement submitSigInAtCheckOut;

    @FindBy(xpath = "//button[text()='Continue as Guest']")
    WebElement continueAsGuest;

    @FindBy(id = "user.emailAddress")
    WebElement emailAtCheckOut;

    @FindBy(id = "user.phone")
    WebElement mobileNumAtCheckOut;

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


    @FindBy(xpath = "//input[@aria-labelledby='first-name-help']")
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

    public void contactInfoAtCheckOut() throws Exception {

        typeText(emailAtCheckOut, "naveenrajv129@gmail.com");
        typeText(mobileNumAtCheckOut, "9066543213");
        eleClick(textUpdateCheckBox, 15);


    }

    public void continueAsGuestButton() {
        explicitWait(continueAsGuest, 15);
        eleClick(continueAsGuest, 15);
    }

    public String enterAddressOnCheckOut() throws InterruptedException {
        typeText(firstName, "Naveen");
        typeText(lastName, "Raj");
        typeText(address, "N Calle 11");
        typeText(city, "silverspring");
        elementClick(state);
        selectFromDropDown(state, "DC");
        typeText(postalCode, "00646");
        Thread.sleep(2000);
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
        eleClick(submitSigInAtCheckOut, 15);
        typeText(emailAtCheckOut, "naveenrajv129@gmail.com");
        typeText(mobileNumAtCheckOut, "8778335842");
        eleClick(textUpdateCheckBox, 15);

    }

}
