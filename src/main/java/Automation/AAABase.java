package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class AAABase {
    public WebDriver driver;

    @Parameters({"browserName"})
    @BeforeSuite
    public void initializeDrivers(String browserName){
        switch (browserName){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBrowserVersion("119");
                driver = new ChromeDriver();
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBrowserVersion("119");
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Enter valid browsername");
        }

    }

    @Parameters({"url"})
    @BeforeTest
    public void launchApplication(String url){
        driver.get(url);
    }

    @AfterSuite
    public void killSession(){
        driver.quit();
    }
}
