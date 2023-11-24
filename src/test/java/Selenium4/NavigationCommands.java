package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NavigationCommands {
    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        //driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement abTestingLink = driver.findElement(By.cssSelector("a[href='/abtest']"));
        System.out.println("abTestingLink :: " + abTestingLink);
        abTestingLink.click();

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();

        System.out.println("abTestingLink :: " + abTestingLink);
        WebElement addOrRemoveElements = driver.findElement(By.linkText("Add/Remove Elements"));
        System.out.println("addOrRemoveElements :: " + addOrRemoveElements);

        driver.quit();
    }
    }
