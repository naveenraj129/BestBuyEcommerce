package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;

public class CreteAccountPage extends WebUtility {

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


    public CreteAccountPage() {

        PageFactory.initElements(driver, this);
    }

    public String createAccountFunctionality(String fName, String lName, String email,
                                             String password, String confirmPassword, String mobileNumber, String textXpath) {
        typeText(firstName, fName);
        typeText(lastName, lName);
        typeText(this.Email, email);
        typeText(this.Password, password);
        typeText(this.confirmPassword, confirmPassword);
        typeText(this.Phone, mobileNumber);
        elementClick(createAccount);
        String actMsg = driver.findElement(By.xpath("" + textXpath + "")).getText();
        return actMsg;
    }
}
