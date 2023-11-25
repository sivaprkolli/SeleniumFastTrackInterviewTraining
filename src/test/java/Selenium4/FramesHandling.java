package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FramesHandling {

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
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        WebElement topFrame = driver.findElement(By.xpath("//frame[@src='/frame_top']"));
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame("frame-left");
        Assert.assertTrue(driver.findElement(By.xpath("//body[normalize-space()='LEFT']")).isDisplayed());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(driver.findElement(By.xpath("//body/div[normalize-space()='MIDDLE']")).isDisplayed());


        driver.switchTo().defaultContent(); // out of all frames
        driver.switchTo().frame(topFrame); // switch to parent
        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.xpath("//body[normalize-space()='RIGHT']")).isDisplayed());
    }
}
