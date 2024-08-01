package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;

public class CreateAccountPage extends WebUtility {

    @FindBy(xpath = "//input[@id ='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id ='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id ='email']")
    WebElement Email;

    @FindBy(xpath = "//input[@id ='fld-p1' and  @type = 'password']")
    WebElement Password;

    @FindBy(xpath = "//input[@id ='reenterPassword']")
    WebElement rePassword;

    @FindBy(xpath = "//input[@id ='phone']")
    WebElement Phone;

    @FindBy(xpath = "//button[text() = 'Create an Account']")
    WebElement createAccount;

    @FindBy(xpath = "//div[@aria-label='Error']")
    WebElement alert;

    public CreateAccountPage() {

        PageFactory.initElements(driver, this);
    }

    public String createAccountFunctionality(String fName, String lName, String email,
                                             String pass, String repass, String mob, String textXpath) {
        typeText(firstName, fName);
        typeText(lastName, lName);
        typeText(Email, email);
        typeText(Password, pass);
        typeText(rePassword, repass);
        typeText(Phone, mob);
        elementClick(createAccount);
        String actMsg = driver.findElement(By.xpath(textXpath)).getText();
        return actMsg;
    }

    public String createAccountSuccessFunctionality() {
        typeText(firstName, "Naveen");
        typeText(lastName, "Raj");
        typeText(Email, "naveenrajv129@gmail.com");
        typeText(Password, "EVANaura@129");
        typeText(rePassword, "EVANaura@129");
        typeText(Phone, "8778335842");
        eleClick(createAccount, 10);
        explicitWait(alert, 15);
        String actMsg = alert.getText();
        return actMsg;
    }
}
