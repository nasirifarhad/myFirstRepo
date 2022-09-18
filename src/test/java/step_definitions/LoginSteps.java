package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BaseClass_PO;
import pageObject.LoginPO;


public class LoginSteps extends BaseClass_PO {

    //private final WebDriver driver = getDriver();

//private LoginPO loginpo;
//private LoginSteps(LoginPO loginpo) {
//    this.loginpo = loginpo;   }

    LoginPO loginpo = new LoginPO();     //making obj of loginPO or like above

    @Given("I access the login page")
    public void i_access_the_login_page() {
    loginpo.navigateToTheUniWebDriveLoginPage();//calling this method from loginPO
        //driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
        //navigate_To_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");
        //the above is a method which centralized in BaseClass_PO
    }
    @When("I enter valid user name")
    public void i_enter_valid_user_name() {
        //driver.findElement(By.id("text")).sendKeys("webdriver");    //(hard coded)
        //sendKeys(By.id("text"),"webdriver"); // from baseClass
        loginpo.setUserName("webdriver");  //from loginPO
    }

    @And("I enter valid password")
    public void i_enter_valid_password() {
        loginpo.setPassword("webdriver123");
    }

    @And("I enter invalid user name")
    public void i_enter_invalid_user_name() {
        //driver.findElement(By.id("text")).sendKeys("username");
        //sendKeys(By.id("text"), "username");
        loginpo.setUserName("username");
    }

    @And("I enter invalid password")
    public void i_enter_invalid_password() {
        //driver.findElement(By.id("password")).sendKeys("password");
        //sendKeys(By.id("password"), "password");
        loginpo.setPassword("password");
    }

    @And("click on login button")
    public void click_on_login_button()  {
        //driver.findElement(By.id("login-button")).click();
        loginpo.clickOnLoginButton();
    }

    @Then("I should get the login message")
    public void i_should_get_the_login_success_message() {
//        String loginMsg = driver.switchTo().alert().getText();
//        if (loginMsg.contains("validation succeeded")) {
//            System.out.println(loginMsg + " - login success ");
//        } else {
//            System.out.println(loginMsg + " - login invalid");
//        }
//        driver.switchTo().alert().accept();
  //  }

    //Scenario outline step definitions
        loginpo.waitAndValidateSuccessfulAlert();}

    @When("I enter a {word}")
    public void i_enter_a_webdriver(String username) {
        //driver.findElement(By.id("text")).sendKeys(username);
            loginpo.setUserName(username);
    }

    @And("I enter  a {word}")
    public void i_enter_webdriver123(String password) {
        //driver.findElement(By.id("password")).sendKeys(password);
        loginpo.setPassword(password);
    }

    @Then("I should get the {}")   //when we use {} we can pass anything
    public void i_should_get_the_validation_succeeded(String expectedMsg) {
       waitForAlertAndValidateText(expectedMsg);
    }
}

