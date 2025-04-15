package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class WithOutThreadLocal {
    public static DesiredCapabilities desiredCapabilities;
   static WebDriver driver;

    @Parameters({"browserName"})
    @BeforeTest
    public void setup(String browserName) throws MalformedURLException {
        driver = setupBrowser(browserName);
        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());
    }

    public static WebDriver setupBrowser(String browserName) throws MalformedURLException {
        WebDriver driver = null;
        switch (browserName){
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("browserName", "firefox");
                firefoxOptions.merge(desiredCapabilities);
                driver = new FirefoxDriver(firefoxOptions);
                // driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), firefoxOptions);
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("browserName", "chrome");
                chromeOptions.merge(desiredCapabilities);
                driver = new ChromeDriver(chromeOptions);
                //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                desiredCapabilities = new DesiredCapabilities();
                //desiredCapabilities.setCapability("platfromName", Platform.MAC);
                desiredCapabilities.setCapability("browserName", "MicrosoftEdge");
                edgeOptions.merge(desiredCapabilities);
                driver = new EdgeDriver(edgeOptions);
                //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), edgeOptions);
                break;

           /* case "safari":
                SafariOptions safariOptions = new SafariOptions();
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platfromName", Platform.MAC);
                desiredCapabilities.setCapability("browserName", "safari");
                safariOptions.merge(desiredCapabilities);
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), safariOptions);
                break;*/
        }

        return driver;

    }

    @Test
    public void assignmnetTest1() throws InterruptedException {

        driver.get("https://www.saucedemo.com/");

        WebElement userNameInputBox = driver.findElement(By.cssSelector("#user-name"));
        userNameInputBox.sendKeys("standard_user");
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        loginButton.click();
        WebElement productsHeading = driver.findElement(By.cssSelector(".title"));
        Assert.assertTrue(productsHeading.isDisplayed());
    }

   // @Test
    public void assignmnetTest2() throws InterruptedException {

        driver.get("https://www.saucedemo.com/");

        WebElement userNameInputBox = driver.findElement(By.cssSelector("#user-name"));
        userNameInputBox.sendKeys("standard_user");
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        loginButton.click();

        WebElement productsHeading = driver.findElement(By.cssSelector(".title"));
        Assert.assertTrue(productsHeading.isDisplayed());
    }

    @AfterTest
    public void killSession() {
        driver.quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        //threadLocalDriver.remove();
    }
}
