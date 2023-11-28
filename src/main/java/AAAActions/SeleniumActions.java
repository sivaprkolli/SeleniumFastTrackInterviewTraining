package AAAActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActions {
    private WebDriver driver;

    public SeleniumActions(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnElement(WebElement element){
        element.click();
        System.out.println("Successfully clicked on element");
    }

    public void clickOnElement(By locator){
        driver.findElement(locator).click();
        System.out.println("Successfully clicked on element");
    }

    public void enterValue(WebElement element, String data){
        element.sendKeys(data);
    }

    public void enterValue(By locator, String data){
        driver.findElement(locator).sendKeys(data);
    }
}
