package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginUsingSauceDemo {
    public static WebDriver driver;
    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
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
    public void killSession(){
        driver.quit();
    }
}
