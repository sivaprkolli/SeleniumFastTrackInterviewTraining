package SeleniumGrid;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelExecutionUsingGridLocally {

//https://www.linkedin.com/pulse/selenium-parallel-testing-using-java-threadlocal-testng-shargo/
    public static DesiredCapabilities desiredCapabilities;
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    @Parameters({"browserName"})
    @BeforeTest
    public void setup(String browserName) throws MalformedURLException {
        WebDriver driver = setupBrowser(browserName);
        threadLocalDriver.set(driver);
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
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), firefoxOptions);
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("browserName", "chrome");
                chromeOptions.merge(desiredCapabilities);
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platfromName", Platform.MAC);
                desiredCapabilities.setCapability("browserName", "MicrosoftEdge");
                edgeOptions.merge(desiredCapabilities);
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), edgeOptions);
                break;

            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platfromName", Platform.MAC);
                desiredCapabilities.setCapability("browserName", "safari");
                safariOptions.merge(desiredCapabilities);
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), safariOptions);
                break;
        }

        return driver;

    }

    @Test
    public void assignmnetTest() throws InterruptedException {
        Thread.sleep(2000);
        getDriver().get("https://www.saucedemo.com/");

        WebElement userNameInputBox = getDriver().findElement(By.cssSelector("#user-name"));
        userNameInputBox.sendKeys("standard_user");

        WebElement passwordInputBox = getDriver().findElement(By.name("password"));
        passwordInputBox.sendKeys("secret_sauce");

        WebElement loginButton = getDriver().findElement(By.cssSelector(".submit-button.btn_action"));
        loginButton.click();
        WebElement productsHeading = getDriver().findElement(By.cssSelector(".title"));
        Assert.assertTrue(productsHeading.isDisplayed());
    }

    @AfterTest
    public void killSession() {
        getDriver().quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        threadLocalDriver.remove();
    }
}
