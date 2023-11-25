package Selenium4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AlertsHandling {
    public static WebDriver driver;

    @AfterTest
    public void killSession(){
        driver.quit();
    }

    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("alertText :: " + alertText);
        alert.accept();

    }
}
