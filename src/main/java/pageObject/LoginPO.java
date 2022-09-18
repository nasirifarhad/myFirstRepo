package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BaseClass_PO {
    private @FindBy(id = "text")
    WebElement usernameTextField;

    private @FindBy(id = "password")
    WebElement passwordTextField;

    private @FindBy(id = "login-button")
    WebElement loginButton;


    public LoginPO (){
        super();
    }
    public void navigateToTheUniWebDriveLoginPage(){
        navigate_To_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }
    public void setUserName(String userName){
        sendKeys(usernameTextField,userName);
 }
    public void setPassword(String password){
        sendKeys(passwordTextField,password);
    }
    public void clickOnLoginButton (){
        waitForElementAndClick(loginButton);
    }
    public void waitAndValidateSuccessfulAlert(){
        waitForAlertAndValidateText("validation succeeded");
}
    public void waitAndValidateUnSuccessfulAlert(){
        waitForAlertAndValidateText("validation failed");
    }





}
