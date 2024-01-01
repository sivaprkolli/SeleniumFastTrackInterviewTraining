package SeleniumGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ThreadLocalDriver {
    //create a generic thread-local object
    protected static ThreadLocal<WebDriver> myThreadLocal = new ThreadLocal<>();


    public WebDriver setUpBrowser(){
        WebDriver driver = null;

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("119");
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    public static WebDriver getDriver(){
        return myThreadLocal.get();
    }

    @Test
    public void startSession(){
        WebDriver driver = setUpBrowser();
        myThreadLocal.set(driver);

        getDriver().get("https://www.linkedin.com/feed/");
        getDriver().quit();
        myThreadLocal.remove();
    }
}
