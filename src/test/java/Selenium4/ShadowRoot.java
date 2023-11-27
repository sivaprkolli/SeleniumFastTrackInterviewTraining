package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ShadowRoot {

    WebDriver driver;
    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
        driver.get("https://books-pwakit.appspot.com/");

        SearchContext shadowRootElement = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        shadowRootElement.findElement(By.cssSelector("input[aria-label=\"Search Books\"]")).sendKeys("Test123");




    }
}
