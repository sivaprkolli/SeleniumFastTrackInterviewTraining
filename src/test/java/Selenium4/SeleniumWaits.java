package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWaits {
    WebDriver driver;
    double startTime;
    double endTime;
@AfterTest
public void killSession(){
    endTime = System.currentTimeMillis();
    System.out.println("endTime :: " + endTime);
    double totalTime = endTime - startTime;
    System.out.println(totalTime);
    driver.quit();
}

    @Test
    public void launchApplication(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("119");

        driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        startTime = System.currentTimeMillis();
        System.out.println("startTime :: " + startTime);
      // WebElement freeTrail = driver.findElement(By.name("start my free tria"));

        //Explicit - WebDriverWait, FluentWait

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        webDriverWait
                .until(
                        ExpectedConditions.elementToBeClickable(driver.findElement(By.name("start my free trial")))
                );

        Assert.assertTrue(webDriverWait.until(ExpectedConditions.titleIs("Free CRM Trial: Salesforce 30-Day Trial - Salesforce IN")));


        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .withMessage("Failed due to element not found")
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(8));


        fluentWait
                .until(
                        ExpectedConditions.elementToBeClickable(By.name("start my free tria"))
                );
    }


}
