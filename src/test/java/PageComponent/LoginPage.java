package PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;

import static utils.WebUtility.*;

public class LoginPage {

    @FindBy(xpath = "//input[@type = 'email']")
    WebElement emailId;
    @FindBy(xpath = "//input[@type = 'password']")
    WebElement Password;
    @FindBy(xpath="//button[text()='Sign In']")
    WebElement loginButton;

    @FindBy(xpath = "//a[text() = 'Return to previous page']")
    WebElement returnPreviousPage;

//    @FindBy(xpath = "//button[text() = 'Skip for now']")
//    WebElement skipButton;

//    @FindBy(xpath = "//div[text() ='Sorry, something went wrong. Please try again.']")
//    WebElement signInSuccessful;

//    @FindBy(xpath = "//div[text()='Oops! The email or password did not match our records. Please try again.']")
//    WebElement invalidEmail;
//    @FindBy(xpath = "//div[text()='Oops! The email or password did not match our records. Please try again.']")
//    WebElement incorrectPassword;

    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    public void correctCredentials() throws InterruptedException {
        typeText(emailId, "naveen2@gmail.com");
        typeText(Password, "EVANaura@129");
        elementClick(loginButton);
        explicitWait(returnPreviousPage , 15);
        eleClick(returnPreviousPage , 30);
//        eleClick(skipButton, 50);

    }


//    public String invalidMailId() {
//
//        typeText(emailId, "naveen.com");
//        typeText(Password, "EVANaura@129");
//        eleClick(loginButton, 15);
//
//        //return invalidEmail.getText();
//    }
//
//    public String invalidPassword() {
//
//        typeText(emailId, "naveen2@gmail.com");
//        typeText(Password, "nave@129");
//        eleClick(loginButton, 15);
//
//       //return incorrectPassword.getText();
//    }
}
