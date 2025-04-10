package DesignPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements BrowserDriver {

    private static ChromeDriverManager instance;

    private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();
    ChromeDriverManager(){}

    @Override
    public WebDriver createDriver() {
         tDriver.set(new ChromeDriver());
         return  tDriver.get();
    }


}
