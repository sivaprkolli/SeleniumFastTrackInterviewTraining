package JavaScriptExecutorTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSETests {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    @BeforeTest
    public void launchApp(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void clickUsingJS() {
        //javascriptExecutor = (JavascriptExecutor) driver;
        WebElement abTestingLink = driver.findElement(By.xpath("//a[@href='/abtest']"));
        String clickElement = "return arguments[0].click()";
        javascriptExecutor.executeScript(clickElement, abTestingLink);
        WebElement seleniumElementalLink = driver.findElement(By.linkText("Elemental Selenium"));
        javascriptExecutor.executeScript(clickElement, seleniumElementalLink);
    }


    @Test
    public void typeUsingJS(){
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        WebElement firstNameInputBox = driver.findElement(By.cssSelector("[name=\"UserFirstName\"]"));
        String typeValue1 = "return arguments[0].value=''";
        String typeValue = "return arguments[0].value='SivaAutomation'";
        javascriptExecutor.executeScript(typeValue1, firstNameInputBox);
        javascriptExecutor.executeScript(typeValue, firstNameInputBox);
    }

    @Test
    public void scrollToElement(){
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        WebElement firstNameInputBox = driver.findElement(By.xpath("//a[normalize-space()='Your Privacy Choices']"));

        String scrollToEle = "return arguments[0].scrollIntoView(true)";
        javascriptExecutor.executeScript(scrollToEle, firstNameInputBox);

        //javascriptExecutor.executeScript("alert('I love Selenium')");
WebElement startMyFreeStyleButton = driver.findElement(By.name("start my free trial"));
        String colourChange = "return arguments[0].setAttribute('style','background-color:#FF0000')";
        javascriptExecutor.executeScript(colourChange,startMyFreeStyleButton );
    }
    @AfterTest
    public void killSession(){
      //  driver.quit();
    }
}
