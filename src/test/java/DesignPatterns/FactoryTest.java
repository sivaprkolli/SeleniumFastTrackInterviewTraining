package DesignPatterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FactoryTest {

    WebDriver driver;
    @BeforeTest
    public void setUp(){

        driver= DriverFactory.getDriver("chrome").createDriver();
    }

    @Test
    public void verifyLogin(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterTest
    public void killSession(){
        driver.quit();
    }
}
