package WorkDay;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWD {
    WebDriver driver;
    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://.test.com/test/d/home.htmld");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement navBar = driver.findElement(By.cssSelector("[title=\"Global Navigation\"]"));
        navBar.click();

        driver.findElement(By.xpath("//span[text()='Personal Information']")).click();

    }

}
