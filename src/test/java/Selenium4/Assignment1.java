package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment1 {
    WebDriver driver;

    @Test
    public void sampleTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("url");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.xpath("(//span[text()='Select Region'])[position()=1]")).click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement location = driver.findElement(By.xpath("(//a[text()='York'])[1]"));

        jse.executeScript("arguments[0].scrollIntoView()",location);

        location.click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[aria-labelledby*='from']")).sendKeys("City Centre, York, UK");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space(text())='City Centre, York, UK']")).click();
        driver.findElement(By.cssSelector("[aria-labelledby*='to']")).sendKeys("Minster Yard, York, UK");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space(text())='Minster Yard, York, UK']")).click();


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
