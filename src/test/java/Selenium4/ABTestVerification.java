package Selenium4;

import SeleniumLogs.LogsCheck;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABTestVerification {
    //WebDriver driver;
    private static final Logger logger
            = LoggerFactory.getLogger(LogsCheck.class);
    @Test
    public void abVerificationTest(){
        ChromeOptions options = new ChromeOptions();
       // options.setBrowserVersion("119");
        WebDriver driver = new ChromeDriver(options);


        // will come to know difference after learning waits - will give clarity later
        driver.get("https://the-internet.herokuapp.com/");
        logger.info("Open url - https://the-internet.herokuapp.com/");
      //  driver.navigate().to("https://the-internet.herokuapp.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "The Internet");
        logger.info("Verify title : The Internet");
        WebElement abTestingLink = driver.findElement(By.xpath("//a[@href='/abtest']"));
        System.out.println("abTestingLink :: " + abTestingLink);
        abTestingLink.click();
        // xpath : //div[@class='example']/h3
        // css : .example > h3
        WebElement abTestHeading = driver.findElement(By.cssSelector(".example > h3"));
        boolean abtestHeadingDispalyed = abTestHeading.isDisplayed();
        System.out.println("abtestHeadingDispalyed :: " + abtestHeadingDispalyed);
        Assert.assertTrue(abtestHeadingDispalyed);

        String abTestHeadingText = abTestHeading.getText();
        System.out.println("abTestHeadingText :: " + abTestHeadingText);
        //Assert.assertEquals(abTestHeadingText, "A/B Test Variation 1");
        Assert.assertTrue(abTestHeadingText.contains("A/B Test"));



        driver.quit();
    }
}
