package AAAWaits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {
    private WebDriver driver;
    public WebDriverWait webDriverWait;

    public SeleniumWaits(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void implicitWait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void waitForElementToBeClickable(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
