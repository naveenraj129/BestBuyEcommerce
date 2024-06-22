package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WebUtility.*;

public class LoginPage {

    @FindBy(xpath = "//input[@type = 'email']")
    WebElement emailId;
    @FindBy(xpath = "//input[@type = 'password']")
    WebElement Password;
    @FindBy(xpath = "//button[text()='Sign In']")
    WebElement loginButton;

    @FindBy(xpath = "//a[text() = 'Return to previous page']")
    WebElement returnPreviousPage;


    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    public String validateSignInPage(String email, String password, String textXpath) throws InterruptedException {

        typeText(emailId , email);
        typeText(Password , password);
        eleClick(loginButton , 15);
       String actmsg = driver.findElement(By.xpath(""+textXpath+"")).getText();
       return actmsg;
    }

}
