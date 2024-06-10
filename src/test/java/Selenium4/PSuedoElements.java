package Selenium4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PSuedoElements {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    @BeforeTest
    public void launchApp(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void submitTest() throws IOException, InterruptedException {
        driver.get("https://play1.automationcamp.ir/advanced.html");
        Thread.sleep(3000);
        String actualStar = driver.findElement(By.cssSelector("label.star-rating")).getText();
        System.out.println(actualStar);
        String message = javascriptExecutor.executeScript(
                "return window.getComputedStyle" +
                        "(document.querySelector('.star-rating'),'::after')" +
                        ".getPropertyValue('content')").toString();
        String stars = message.replaceAll("\"","");
        System.out.println(stars);

        char c[] = stars.toCharArray();
        int count = 0;

        for(int i=0; i<c.length; i++){
            if(c[i] == '*'){
                count++;
            }
        }

        System.out.println("number of stars :: " + count);
        driver.quit();


    }
}
