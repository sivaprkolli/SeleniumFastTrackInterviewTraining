package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsHandling {
    public static WebDriver driver;
    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");

        WebElement multipleWindowLink = driver.findElement(By.partialLinkText("Multiple"));
        multipleWindowLink.click();

        WebElement clickHereLink = driver.findElement(By.xpath("//div[@class='example']/h3/following-sibling::a"));
        clickHereLink.isDisplayed();
        String parentWindowId = driver.getWindowHandle();
        System.out.println("parentWindowId :: " + parentWindowId);
        clickHereLink.click();

        Set<String> multipleWindowIds = driver.getWindowHandles();

        System.out.println("multipleWindowIds :: " + multipleWindowIds);
        /*for(int i=0; i<multipleWindowIds.size(); i++){
            driver.switchTo().window(multipleWindowIds)
        }*/

        for(String window : multipleWindowIds){
            driver.switchTo().window(window);
        }

        WebElement newWindowHeading = driver.findElement(By.xpath("//h3[text()='New Window']"));
        Assert.assertTrue(newWindowHeading.isDisplayed());
        driver.close();
        driver.switchTo().window(parentWindowId);
        Assert.assertTrue(clickHereLink.isDisplayed());

        /*driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();*/

        //selenium 4 - introduced
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);

    }
}
