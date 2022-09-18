package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class driverFactory {
    private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webdriver.get() == null) {
            webdriver.set(createWebDriver());
        }
        return webdriver.get();
    }

    private static WebDriver createWebDriver() {
        WebDriver driver = null;
        switch (getBrowserType()) {
            //noinspection SwitchStatementWithoutDefaultBranch
            case "chrome": {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox": {
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case "edge": {
                System.setProperty("webdriver.edge.driver",
                        System.getProperty("user.dir") + "/src/main/java/driver/drivers/msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new EdgeDriver(edgeOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static String getBrowserType() {
        String browserType = null;
        String browserTypeRemoteValue = System.getProperty("browserType");
        try {
            if(browserTypeRemoteValue==null || browserTypeRemoteValue.isEmpty()) {
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                        "/src/main/java/driver/properties/config.properties/");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
                //we make the browser to lowerCase and trim any space
            }else {
                browserType = browserTypeRemoteValue;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    public static void cleanupDriver() {
        webdriver.get().quit();
        webdriver.remove();
    }
}
