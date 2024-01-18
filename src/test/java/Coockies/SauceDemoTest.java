package Coockies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class SauceDemoTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeTest
    public void launchApp(){
       // System.setProperty("webdriver.chrome.driver", "/Users/shiva/Documents/JavaCucumber/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
       // options.setBinary("/Users/shiva/Documents/JavaCucumber/drivers/ChromeTest.app/Contents/MacOS/GoogleChromeforTesting");
        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void loginToEP() throws IOException {
    /*   // webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Log In']"))).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-name"))).sendKeys("standard_user");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password"))).sendKeys("secret_sauce");
       // webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[placeholder='Password']"))).sendKeys("");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-button"))).click();
*/
        SessionManager sessionManager = new SessionManager(driver);
       // sessionManager.storeSessionFile("SauceTest", "standard_user");
        sessionManager.usePreviousLoggedInSession("SauceTest");
    }

    @AfterTest
    public void killSession(){
        driver.quit();
    }
}
