package DockersTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockersSauceDemo {
    public static WebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        FirefoxOptions chromeOptions = new FirefoxOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserName", "firefox");
        chromeOptions.merge(desiredCapabilities);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4445/wd/hub"), chromeOptions);
    }

    @Test
    public void assignmnetTest() throws InterruptedException {
        Thread.sleep(5000);
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
    }
}
