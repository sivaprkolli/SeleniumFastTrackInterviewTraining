package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class UsingThreadLocal {

    WebDriver driver;

    @BeforeTest
    public void intiDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginAsStandardUser() {
        login("standard_user", "secret_sauce");
    }

    @Test
    public void loginAsErrorUser() {
        login("visual_user", "secret_sauce");
    }


    By userNameField = By.name("user-name");
    By passwordField = By.id("password");
    By submitButton = By.cssSelector(".submit-button.btn_action");

    public void login(String un, String pwd) {
        driver.findElement(userNameField).sendKeys(un);
        driver.findElement(passwordField).sendKeys(pwd);
        driver.findElement(submitButton).click();
    }
}
