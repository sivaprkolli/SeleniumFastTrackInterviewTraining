package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class MultipleElements {
    WebDriver driver;

    @AfterTest
    public void killSession() {

        driver.quit();
    }

    @Test
    public void testMultipleElements(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("119");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> links = driver.findElements(By.cssSelector("li > a"));
       // System.out.println(links);

        for (int i=0; i<links.size(); i++) {

            System.out.println("Links :: " + links.get(i).getText());
        }

    }

    @Test
    public void launchApplication() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("119");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Element')]"));

        for(int i=0; i<5; i++){
            addButton.click();
        }

        List<WebElement> deleteElements = driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
        Assert.assertEquals(deleteElements.size(), 5);

        for(int j=0; j<deleteElements.size(); j++){
           // deleteElements.get(j).click();
            driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        }

        driver.navigate().back();

        List<WebElement> links = driver.findElements(By.cssSelector("li > a"));

        System.out.println("Links :: " + links);
    }
}
