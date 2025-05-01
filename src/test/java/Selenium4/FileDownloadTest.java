package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v135.browser.Browser;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.v135.browser.Browser;
import org.openqa.selenium.devtools.v135.browser.model.*;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FileDownloadTest {
    @Test
    public void downloadFile() throws InterruptedException {
        String downloadDir = System.getProperty("user.dir") + "/downloads";

        HashMap<String, String> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadDir);
        chromePrefs.put("download.prompt_for_download", "false");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("start-maximized");
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/download");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("[href='download/sample_media_file.png']")).click();
        Thread.sleep(5000);
        File downloadedFile = new File(downloadDir + "/sample_media_file.png");
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully: " + downloadedFile.getName());
        } else {
            System.out.println("File not downloaded!");
        }

        driver.quit();
    }

    @Test
    public void fileDownloadInHeadless() throws InterruptedException {
        String downloadDir = System.getProperty("user.dir") + "/downloads";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Use new headless mode (Chrome 109+)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

//        devTools.send(Browser.setDownloadBehavior(
//                new DownloadBehavior.SetDownloadBehavior(
//                        DownloadBehavior.SetDownloadBehaviorBehavior.ALLOW,
//                        Optional.of(downloadFilepath),
//                        Optional.of(true))));

        Map<String, Object> params;
        params = new HashMap<>();
        params.put("behavior", "allow");
        params.put("downloadPath", downloadDir);

        driver.executeCdpCommand("Page.setDownloadBehavior", params);

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.cssSelector("[href='download/sample_media_file.png']")).click();
        Thread.sleep(5000);

        File downloadedFile = new File(downloadDir + "/sample_media_file.png");
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully: " + downloadedFile.getName());
        } else {
            System.out.println("File not downloaded!");
        }
        driver.quit();
    }
}
