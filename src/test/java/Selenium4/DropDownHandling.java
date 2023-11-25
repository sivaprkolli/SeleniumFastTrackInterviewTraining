package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDownHandling {
    public static WebDriver driver;

    @AfterTest
    public void killSession(){
        driver.quit();
    }

    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/dropdown");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        WebElement dropDownList = driver.findElement(By.id("dropdown"));
        Select dropDownSelect = new Select(dropDownList);
        dropDownSelect.selectByVisibleText("Option 1");
        String selectedOption = dropDownSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Option 1");

        /* java.lang.UnsupportedOperationException: You may only deselect options of a multi-select
        dropDownSelect.deselectByValue("1");
        String defaultSelectedOption = dropDownSelect.getFirstSelectedOption().getText();
        System.out.println("defaultSelectedOption :: " + defaultSelectedOption);*/


    }
}
