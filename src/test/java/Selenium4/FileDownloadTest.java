package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class FileDownloadTest {
    @Test
    public void downloadFile() throws InterruptedException {
        String downloadDir = System.getProperty("user.dir") + "/downloads";

        HashMap<String, String> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadDir);
        chromePrefs.put("download.prompt_for_download", "false");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/download");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("[href='download/sample.png']")).click();
        Thread.sleep(5000);
        File downloadedFile = new File(downloadDir + "/sample.png");
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully: " + downloadedFile.getName());
        } else {
            System.out.println("File not downloaded!");
        }

        driver.quit();


    }
}
