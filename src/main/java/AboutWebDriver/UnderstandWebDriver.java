package AboutWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UnderstandWebDriver {

    @Test
    public void launchApplication(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("115");

        WebDriver driver = new ChromeDriver(options);
      //  WebDriver firefoxDriver = new FirefoxDriver();


    }

}
