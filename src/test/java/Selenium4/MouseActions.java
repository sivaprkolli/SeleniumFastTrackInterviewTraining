package Selenium4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseActions {

    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    @BeforeTest
    public void launchApp(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
    }

    @Test
    public void submitTest(){
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // post in console for pausing the dropdown
        //setTimeout(()=>{debugger}, 5000)
        driver.findElement(By.xpath("//span[@role=\"button\"]")).click();
        WebElement mainElement = driver.findElement(By.xpath("//span[text()='Electronics']"));
        //WebElement subMenuElement = driver.findElement(By.xpath("//a[text()='Electronics GST Store']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mainElement).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Electronics GST Store']"))).click().perform();
    }

    @Test
    public void usingkeyBaordKeys(){
        driver.get("https://para.testar.org/parabank/about.htm;jsessionid=FB240F858FA900BA96DEE5A980656F85");

        driver.findElement(By.name("username")).sendKeys(Keys.TAB);
        driver.findElement(By.name("username")).submit();
    }
}
