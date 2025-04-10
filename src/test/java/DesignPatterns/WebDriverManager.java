package DesignPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
    private static WebDriverManager instance;

    private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();
    private WebDriverManager(){

    }

    private void initDriver(String browser){
        switch (browser){
            case "chrome":
                tDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tDriver.set(new FirefoxDriver());
                break;
        }
    }
    public static WebDriverManager getInstance(String browser){
        if (instance == null){
            instance = new WebDriverManager();
        }
        if (tDriver.get() == null){
            instance.initDriver(browser);
        }
        return instance;
    }

    public WebDriver getDriver(){
        return tDriver.get();
    }

    public static void quiDriver(){
        if (tDriver.get() != null){
            tDriver.get().quit();
        }
    }
}
