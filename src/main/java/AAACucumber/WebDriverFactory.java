package AAACucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;

public class WebDriverFactory {

    public static WebDriver driver;

    public static void initializeDrivers(String browserName){
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

    public static void launchApplication(String url){
        driver.get(url);
    }

    public static void killSession(){
        driver.quit();
    }
}
