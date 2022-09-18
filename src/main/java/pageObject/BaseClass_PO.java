package pageObject;
import driver.driverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GlobalVars;

import java.time.Duration;

public class BaseClass_PO {
    //this class is to centralize the generic and common codes and methods
    public BaseClass_PO() {
        PageFactory.initElements(getDriver(),this);
    }

    public WebDriver getDriver(){
        return driverFactory.getDriver(); //this is the getDriver from driverFactory class
    }
    public void navigate_To_URL(String url) {
        getDriver().get(url);
    }
    //this METHOD generates random numbers after a given name to make it unique
    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
    //this METHOD generates random string after a given name or comment to make it unique
    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /*custom methods for sendkeys, wait for it then send keys */
    public void sendKeys (By by, String textToTyps) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DefaultExplicitTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToTyps);
    }
    public void sendKeys (WebElement element, String textToTyps) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DefaultExplicitTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToTyps);
    }
    /*custom method to wait then click on web elements */
    public void waitForElementAndClick(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DefaultExplicitTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitForElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DefaultExplicitTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitForAlertAndValidateText(String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DefaultExplicitTimeout));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessageText = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessageText, text);

    }


}
