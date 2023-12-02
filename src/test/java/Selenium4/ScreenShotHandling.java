package Selenium4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShotHandling {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    @BeforeTest
    public void launchApp(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
    }

    @Test
    public void submitTest() throws IOException {
        driver.get("https://domains.squadhelp.com/lpd/name/genarative.ai");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "/ai.png");
        FileUtils.copyFile(source, destination);
    }
}
