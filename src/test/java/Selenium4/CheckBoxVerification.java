package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CheckBoxVerification {
    WebDriver driver;
    @Test
    public void assignmnetTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
         driver = new ChromeDriver(options);
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");

        WebElement agreementCheckBox = driver.findElement(By.cssSelector("#SubscriptionAgreement + div"));
        boolean isCheckBoxPresent = agreementCheckBox.isSelected();
        System.out.println("isCheckBoxPresent :: " + isCheckBoxPresent);

        agreementCheckBox.click();

        boolean isCheckBoxPresentAfterClick = agreementCheckBox.isSelected();
        System.out.println("isCheckBoxPresentAfterClick :: " + isCheckBoxPresentAfterClick);

    }

    @Test
    public void testFlipKart() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("119");
        driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com/search?sid=tyy%2C4io&otracker=CLP_Filters&p%5B%5D=facets.rating%255B%255D%3D4%25E2%2598%2585%2B%2526%2Babove&p%5B%5D=facets.price_range.from%3DMin&p%5B%5D=facets.price_range.to%3D15000&p%5B%5D=facets.brand%255B%255D%3Drealme&p%5B%5D=facets.ram%255B%255D%3D6%2BGB");
        driver.manage().window().maximize();

        WebElement agreementCheckBox = driver.findElement(By.xpath("//div[text()='SAMSUNG']"));
        boolean isCheckBoxPresent = agreementCheckBox.isSelected();
        System.out.println("isCheckBoxPresent :: " + isCheckBoxPresent);

        agreementCheckBox.click();

        boolean isCheckBoxPresentAfterClick = agreementCheckBox.isSelected();
        System.out.println("isCheckBoxPresentAfterClick :: " + isCheckBoxPresentAfterClick);

    }


    @AfterTest
    public void killSession(){
        driver.quit();
    }

    }
