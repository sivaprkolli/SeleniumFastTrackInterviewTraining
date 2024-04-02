package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MyFirstTest {
    public WebDriver driver;

    @Test
    public void assignmnetTest(){
        ChromeOptions options = new ChromeOptions();
        //options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterTest
    public void killSession(){
        driver.close();
        driver.quit();
    }
}
