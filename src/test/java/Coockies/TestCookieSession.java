package Coockies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestCookieSession {
    public static WebDriver driver;

    @BeforeSuite
    public static void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

    }

    @Test
    public void autoLogin(){
        driver.get("https://www.99.co/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        SessionManager sessionManager = new SessionManager(driver);
        sessionManager.usePreviousLoggedInSession("testCookie1");
    }

    @Test
    public void openApp() throws IOException {
        driver.get("https://www.99.co/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.cssSelector("[href=\"/signin\"]")).click();
        driver.findElement(By.name("email_or_phone")).sendKeys("siva8kolli@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Appium@123");
        driver.findElement(By.cssSelector("[data-cy=\"login\"]")).click();

        WebElement continueButton = driver.findElement(By.xpath("//*[text()='Continue']"));
        Actions actions = new Actions(driver);
        int getX = continueButton.getLocation().getX();
        System.out.println("X coordinate: " +getX);
        int getY = continueButton.getLocation().getY();
        System.out.println("Y coordinate: " +getY);
        actions.moveByOffset(getX+300, getY+200).click();
        actions.build().perform();

        SessionManager sessionManager = new SessionManager(driver);
        sessionManager.storeSessionFile("testCookie1", "siva8kolli@gmail.com");
      //  sessionManager.usePreviousLoggedInSession("testCookie1");


        /*JSONObject existingSession = new JSONObject();
        existingSession.put("path","/");
        existingSession.put("domain",".99.co");
        existingSession.put("name","meid");
        existingSession.put("isHttpOnly",false);
        existingSession.put("isSecure",false);
        existingSession.put("expiry","Sun Aug 11 13:47:06 IST 2024");
        existingSession.put("value","64b76b2e-c81f-4467-9160-38921e8099aa");
        sessionManager.setCookies(existingSession);*/
    }

    @AfterSuite
    public static void killSession(){
        driver.quit();
    }
}
