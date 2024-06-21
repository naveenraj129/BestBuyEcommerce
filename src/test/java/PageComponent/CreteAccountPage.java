package PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;

public class CreteAccountPage extends WebUtility {

    //    @FindBy(xpath = "//button[contains(@class , 'account-button')]")
//    WebElement dropDown;
//    @FindBy(xpath ="//a[contains(@class , 'create-account-btn')]" )
//    WebElement CreateAccount;
    @FindBy(xpath = "//input[@id ='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id ='lastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id ='email']")
    WebElement Email;
    @FindBy(xpath = "//input[@id ='fld-p1' and  @type = 'password']")
    WebElement Password;
    @FindBy(xpath = "//input[@id ='reenterPassword']")
    WebElement confirmPassword;
    @FindBy(xpath = "//input[@id ='phone']")
    WebElement Phone;
    @FindBy(xpath = "//label[text() = 'Use for Account Recovery.']")
    WebElement accountRecovery;
    @FindBy(xpath = "//button[text() = 'Create an Account']")
    WebElement createAccount;
    //@FindBy(id = "//*[text()='Sign Up with Google']")
   // WebElement googleSignUp;

    @FindBy(xpath = "//strong[text()='Sorry, there was a problem creating your account.']")
    WebElement errorAccountCreation;

    @FindBy(xpath = "//a[text() = 'Return to previous page']")
    WebElement returnPreviousPage;

    @FindBy(xpath = "//p[text()='Please enter your first name.']")
    WebElement errorFirstName;
    @FindBy(xpath = "//p[text()='Please enter your last name.']")
    WebElement errorLastName;
    @FindBy(xpath = "//p[text()='Please enter a valid email address.']")
    WebElement errorEmail;
    @FindBy(xpath = "//p[text()='Please enter a strong password.']")
    WebElement errorPassword;
    @FindBy(xpath = "//p[text()='Passwords do not match.']")
    WebElement errorConfirmPassword;
    @FindBy(xpath = "//p[text()='Please enter a valid mobile phone number.']")
    WebElement errorPhone;


    public CreteAccountPage() {

        PageFactory.initElements(driver, this);
    }

    public String accountCreated() {
        typeText(firstName, "Naveen");
        typeText(lastName, "raj");
        typeText(Email, "naveen2@gmail.com");
        typeText(Password, "EVANaura@129");
        typeText(confirmPassword, "EVANaura@129");
        typeText(Phone, "8778335842");
       eleClick(accountRecovery ,5);
       eleClick(createAccount , 15);
        return errorAccountCreation.getText();
    }

    public void PreviousPage(){
        eleClick(returnPreviousPage , 15);
    }

    public String withoutFirstName() {
        typeText(lastName, "raj");
        typeText(Email, "naveen2@gmail.com");
        typeText(Password, "EVANaura@129");
        typeText(confirmPassword, "EVANaura@129");
        typeText(Phone, "8778335842");
        eleClick(accountRecovery ,2);
        eleClick(createAccount , 2);

        return errorFirstName.getText();
    }

    public String withoutLastName() {
        typeText(firstName, "Naveen");
        typeText(Email, "naveen2@gmail.com");
        typeText(Password, "EVANaura@129");
        typeText(confirmPassword, "EVANaura@129");
        typeText(Phone, "8778335842");
        eleClick(accountRecovery ,2);
        eleClick(createAccount , 2);

        return errorLastName.getText();
    }

    public String withoutEmail() {
        typeText(firstName, "Naveen");
        typeText(lastName, "raj");
        typeText(Password, "EVANaura@129");
        typeText(confirmPassword, "EVANaura@129");
        typeText(Phone, "8778335842");
        eleClick(accountRecovery ,2);
        eleClick(createAccount , 2);

        return errorEmail.getText();
    }

    public String withoutPassword() {
        typeText(firstName, "Naveen");
        typeText(lastName, "raj");
        typeText(Email, "naveen2@gmail.com");
        typeText(confirmPassword, "EVANaura@129");
        typeText(Phone, "8778335842");
        eleClick(accountRecovery ,2);
        eleClick(createAccount , 2);

        return errorPassword.getText();
    }

    public String withoutConfirmPassword() {
        typeText(firstName, "Naveen");
        typeText(lastName, "raj");
        typeText(Email, "naveen2@gmail.com");
        typeText(Password, "EVANaura@129");
        typeText(Phone, "8778335842");
        eleClick(accountRecovery ,2);
        eleClick(createAccount , 2);

        return errorConfirmPassword.getText();
    }

    public String withoutMobile() {
        typeText(firstName, "Naveen");
        typeText(lastName, "raj");
        typeText(Email, "naveen2@gmail.com");
        typeText(Password, "EVANaura@129");
        typeText(confirmPassword, "EVANaura@129");
        eleClick(accountRecovery ,2);
        eleClick(createAccount , 2);

        return errorPhone.getText();
    }
}
