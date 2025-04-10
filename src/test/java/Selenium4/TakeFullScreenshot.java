package Selenium4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TakeFullScreenshot {
    @Test
    public void getFullScreenshot() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/in/?ir=1");
        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long totalHeight = (long) js.executeScript("return document.body.scrollHeight");

        int viewportHeight = driver.manage().window().getSize().getHeight();
        int y = 0;

        List<BufferedImage> images = new ArrayList<>();

        while (y < totalHeight) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(screenshot);
            images.add(image);
            js.executeScript("window.scrollBy(0, arguments[0]);", viewportHeight);
            Thread.sleep(500);
        }

// Merge images into one (You can use OpenCV or Java Image API)
        BufferedImage finalImage = mergeImages(images);
        ImageIO.write(finalImage, "PNG", new File("full_screenshot.png"));

    }

    public static BufferedImage mergeImages(List<BufferedImage> images) {
        int totalWidth = images.get(0).getWidth();  // Assume all images have the same width
        int totalHeight = images.stream().mapToInt(BufferedImage::getHeight).sum();  // Sum of all heights

        // Create a new final image with the combined height
        BufferedImage finalImage = new BufferedImage(totalWidth, totalHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = finalImage.createGraphics();

        int currentY = 0;  // Y position to draw the next image
        for (BufferedImage image : images) {
            g2d.drawImage(image, 0, currentY, null);
            currentY += image.getHeight();
        }
        g2d.dispose();  // Clean up

        return finalImage;
    }
}
