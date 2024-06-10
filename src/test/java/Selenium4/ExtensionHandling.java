package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class ExtensionHandling {

    public static WebDriver driver;

    //@AfterTest
    public void killSession(){
        driver.quit();
    }

    @Test
    public void assignmentTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.setBrowserVersion("121");
        options.addExtensions(new File("testADB.crx"));
        options.addArguments("--allow-cors");
        //options.setCapability("chrome.setProxyByServer", false);
        //options.setProxy(Proxy.extractFrom(options.setProxy()));
        driver = new ChromeDriver(options);

        driver.get("chrome-extension://dpngiggdglpdnjdoaefidgiigpemgage/popup.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement inspectButton = driver.findElement(By.cssSelector("#devices"));
        String inspectElementText = inspectButton.getText();
        System.out.println("inspectElementText === " + inspectElementText);
        inspectButton.click();
        Thread.sleep(40000);
        Set<String> windows = driver.getWindowHandles();
        for(String window: windows){
            driver.switchTo().window(window);
        }

        WebElement inspectPage = driver.findElement(By.xpath("//div[contains(text(),'Selenium')]/../following-sibling::div/span[text()='inspect']"));
        inspectPage.isDisplayed();
        inspectPage.click();

        Set<String> inspector = driver.getWindowHandles();
        for(String window: inspector){
            driver.switchTo().window(window);
        }
        driver.close();

        driver.quit();


    }
    }
