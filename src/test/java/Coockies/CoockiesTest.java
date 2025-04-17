package Coockies;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class CoockiesTest {
    WebDriver driver;
    Set<Cookie> allCookies;
    @Test
    public void loginToSauceDemo() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("#Email")).clear();
        driver.findElement(By.cssSelector("#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.className("password")).clear();
        driver.findElement(By.className("password")).sendKeys("admin");
        driver.findElement(By.cssSelector(".login-button")).click();
        Thread.sleep(5000);
        allCookies = driver.manage().getCookies();

        for(Cookie cookie: allCookies){
            System.out.println(cookie);
        }
        driver.close();
    }

    @Test(dependsOnMethods = "loginToSauceDemo")
    public void autoLoginToSauceDemo() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/Admin/Discount/List");
        Thread.sleep(2000);
        for(Cookie cookie: allCookies){
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.close();
    }
}
