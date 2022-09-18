package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.BaseClass_PO;

import java.io.IOException;

import static driver.driverFactory.getDriver;

public class Contact_us_step_definitions extends BaseClass_PO {
//
//    private WebDriver driver;
//
//    @Before
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver",
//        System.getProperty("user.dir")+ "/src/test/java/drivers/chromedriver.exe");
//
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver = new ChromeDriver(chromeOptions);

//        System.setProperty("webdriver.gecko.driver",
//        System.getProperty("user.dir") + "/src/test/java/drivers/geckodriver.exe");
//
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver= new FirefoxDriver(firefoxOptions);

//        System.setProperty("webdriver.edge.driver",
//        System.getProperty("user.dir") + "/src/test/java/drivers/msedgedriver.exe");
//
//        EdgeOptions edgeOptions = new EdgeOptions();
//        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver = new EdgeDriver(edgeOptions);

//
//
//
//
//        driver.manage().window().maximize();
//
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }

    private WebDriver driver = getDriver();


    @Given("I Access to university home page")
    public void i_access_to_university_home_page()  {
       // driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
        navigate_To_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
        //the above is a method which centralized in BaseClass_PO
    }

    @When("I enter first name")
    public void i_enter_first_name()  {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys
                ("AutoFN" + generateRandomNumber(5));


    }

    @And("I enter last name")
    public void i_enter_last_name()  {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys
                ("AutoLN" + generateRandomNumber(5));


    }

    @And("I enter email")
    public void i_enter_email() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys
                ("automail" + generateRandomNumber(3) + "@mail.com");


    }

    @And("I write comment")
    public void i_write_comment()  {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys
                ("This is a very good website" + generateRandomString(40));


    }


    // SPECIFIC DATA
    //instead of khan we can pass {word} here and we can paramerize the method with string
    // firstName so then we can use any name in scenario
    //remeber that we can only use words means that no spaces between, like: (gdf._564hjk)
    // but if we pass{String}instead of{word}we can use words with spaces like commet method
    @When("I enter specific first name {word}")
    public void i_enter_specific_first_name_khan(String fName)  {
        //now if we print or execute fName it will return the name which we pass in our Scenario
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(fName);

    }

    @And("I enter specific last name {word}")
    public void i_enter_specific_last_name_baba(String lName)  {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lName);

    }

    //in the following we can use {word} because there is no space between characters
    @And("I enter specific email {word}")
    public void i_enter_specific_email_khanbaba_mail_com(String email)  {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);


    }

    // this string works when you want to change it in cucumber Scenario between Quotes ""
    @And("I write specific comment {string}")
    public void i_write_specific_comment(String comment)  {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);

        //at end when go back to ur Scenario u can see that the words changed color
        // and you can replace it to any words, names and string you desire

    }

    @And("I click on submit button")
    public void i_click_on_submit_button()  {
        driver.findElement(By.xpath("//input[@class='contact_button'][2]")).click();


    }

    @Then("I should see the successful submission message")
    public void i_should_see_the_successful_submission_message() {
        WebElement successful_submission_msg = driver.findElement(By.xpath("//div[@id=\"contact_reply\"]/h1"));
        Assert.assertEquals(successful_submission_msg.getText(), "Thank You for your Message!");
    }

}

