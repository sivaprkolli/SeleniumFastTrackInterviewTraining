package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SubmitTest {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    @BeforeTest
    public void launchApp(){
        ChromeOptions options = new ChromeOptions();
       // options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
    }

    @Test
    public void submitTest(){
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");

        driver.findElement(By.cssSelector("div[id^='SubscriptionAgreement']")).submit();
    }

    @Test
    public void xpathWithSingleQuote(){
        driver.get("http://localhost:8080/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        clickOnElement("job/shiva's/");
        System.out.println("Test");

    }

    public void clickOnElement(String text){
        WebElement ele = driver.findElement(By.cssSelector("td a[href=\""+text+"\"]"));
        ele.click();
    }
}
