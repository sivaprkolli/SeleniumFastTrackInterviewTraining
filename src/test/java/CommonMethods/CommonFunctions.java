package CommonMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator, int maxRetries) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Clicked element successfully: " + locator.toString());
        } catch (StaleElementReferenceException | ElementClickInterceptedException | TimeoutException e) {
            if (maxRetries > 0) {
                System.out.println("Retrying click. Remaining attempts: " + maxRetries + " on " + locator.toString());
                click(locator, maxRetries-1);
            } else {
                System.out.println("Max retries reached. Could not click element: " + locator.toString());
                throw e;
            }
        }
    }
}

