package Selenium4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class TakeFullPageSC {
    public static void main(String[] args) throws Exception {
        // Set ChromeDriver path
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.salesforce.com/in/?ir=1");

        // Method 1: Using Chrome DevTools Protocol (best for full page)
        takeFullPageScreenshot(driver, "fullpage_screenshot.png");

        driver.quit();
    }

    public static void takeFullPageScreenshot(WebDriver driver, String filePath) throws Exception {
        // Get total page height
        Long totalHeight = (Long) ((JavascriptExecutor) driver).executeScript(
                "return Math.max(document.body.scrollHeight, document.body.offsetHeight, " +
                        "document.documentElement.clientHeight, document.documentElement.scrollHeight, " +
                        "document.documentElement.offsetHeight);");

        // Get viewport height
        Long viewportHeight = (Long) ((JavascriptExecutor) driver).executeScript(
                "return Math.max(document.documentElement.clientHeight, window.innerHeight);");

        // Scroll and stitch screenshots
        Long currentPosition = 0L;
        int index = 0;

        while (currentPosition < totalHeight) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + currentPosition + ");");
            Thread.sleep(500); // Wait for scroll

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(screenshot);

            // Implement image stitching logic here
            // (You'll need to combine multiple screenshots)

            currentPosition += viewportHeight;
            index++;
        }

        // For simpler solution, just resize window and take single screenshot
        // driver.manage().window().setSize(new Dimension(1920, totalHeight.intValue()));
        // driver.manage().window().setSize(new Dimension(driver.manage().window().getSize().getWidth(), totalHeight.intValue()));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(filePath));
    }
}
