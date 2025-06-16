package AAAWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumWaits {
    private WebDriver driver;
    public WebDriverWait webDriverWait;

    public SeleniumWaits(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void implicitWait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void waitForElementToBeClickable(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement checkEvery5SecondsForSingleResultOrFailIfNoData(WebDriver driver, By resultLocator, By noDataLocator, int maxTimeoutInSeconds) {
        int pollInterval = 5;
        int elapsedTime = 0;

        while (elapsedTime < maxTimeoutInSeconds) {
            // Check if 'No Data Found' is present and visible
            List<WebElement> noDataElements = driver.findElements(noDataLocator);
            if (!noDataElements.isEmpty() && noDataElements.get(0).isDisplayed()) {
                throw new AssertionError("Test Failed: 'No Data Found' message is displayed.");
            }

            // Check if exactly one result is present and visible
            List<WebElement> results = driver.findElements(resultLocator);
            if (results.size() == 1 && results.get(0).isDisplayed()) {
                return results.get(0); // Success
            }

            // Wait before next poll
            try {
                Thread.sleep(pollInterval * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted during wait.", e);
            }

            elapsedTime += pollInterval;
        }
        throw new AssertionError("Test Failed: Timeout waiting for exactly one visible result.");
    }

}
