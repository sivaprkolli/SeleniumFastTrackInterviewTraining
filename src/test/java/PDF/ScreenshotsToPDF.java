package PDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScreenshotsToPDF {
    static WebDriver driver;

    public static void main(String[] args) {
       driver = new ChromeDriver();
        List<String> screenshotPaths = new ArrayList<>();

        try {
            driver.get("https://www.saucedemo.com/");
            screenshotPaths.add(captureScreenshot("step1"));

            // Perform another action and capture a screenshot
            WebElement element = driver.findElement(By.cssSelector("#login-button"));
            element.click();  // Example action
            screenshotPaths.add(captureScreenshot("step2"));
            // Generate PDF from screenshots
            createPdfFromScreenshots(screenshotPaths, "Screenshots.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
            driver.quit();
        }
    }

    public static String captureScreenshot(String stepName) throws IOException {
        // Capture screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = "downloads/" + stepName + ".png";
        File destFile = new File(filePath);

        // Save the screenshot to the desired path
        FileUtils.copyFile(srcFile, destFile);
        return filePath;
    }

    public static void createPdfFromScreenshots(List<String> screenshotPaths, String outputPdf) throws IOException {
        // Create a new PDF document
        PDDocument document = new PDDocument();

        for (String path : screenshotPaths) {
            // Add a new page for each screenshot
            PDPage page = new PDPage();
            document.addPage(page);

            // Load the image
            PDImageXObject pdImage = PDImageXObject.createFromFile(path, document);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Draw the image on the page
            contentStream.drawImage(pdImage, 20, 100, 500, 300); // Adjust dimensions as needed
            contentStream.close();
        }

        // Save the document as a PDF
        document.save(outputPdf);
        document.close();
    }
}
