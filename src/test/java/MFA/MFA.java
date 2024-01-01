package MFA;

import com.google.zxing.*;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MFA {
    WebDriver driver;
    @Test
    public void getOTP() throws InterruptedException, IOException, NotFoundException {

        driver = new ChromeDriver();
        driver.get("https://lifeworkstesting-uk.test.lifeworks.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Accept all cookies']"))).click();
        driver.findElement(By.id("username")).sendKeys("yopmail.com");
        driver.findElement(By.cssSelector("button[aria-label='Next']")).click();
        driver.findElement(By.id("password")).sendKeys("password");
                driver.findElement(By.cssSelector("button[aria-label='Log In']")).click();
        try{
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Get Started']")));
            driver.findElement(By.xpath("//button[normalize-space()='Get Started']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@class,'mfa-setup-step-module__container')]/div/*[name()='svg']")));
            WebElement qrCode = driver.findElement(By.xpath("//div[starts-with(@class,'mfa-setup-step-module__container')]/div/*[name()='svg']"));
            takeElementScreenshot(qrCode);
        }catch (NoSuchElementException nse){
        }
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.open();");

        String parentWindowId = driver.getWindowHandle();
        Set<String> numberOfWindows = new HashSet<String>();
        numberOfWindows = driver.getWindowHandles();
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }


        driver.get("http://127.0.0.1:8080/qrCode/elementLogo.png");
        Thread.sleep(3000);
        String qrcodeImage = driver.findElement(By.tagName("img")).getAttribute("src");
        Thread.sleep(3000);
        URL urlOfImage = new URL(qrcodeImage);
        BufferedImage bufferedImage = ImageIO.read(urlOfImage);
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        String textInQRCode = result.getText();
        System.out.println("textInQRCode ==== " + textInQRCode);
        driver.switchTo().window(parentWindowId);
        String actualSecretCode = textInQRCode;
        actualSecretCode = actualSecretCode.substring(actualSecretCode.indexOf("=") + 1);
        actualSecretCode = actualSecretCode.substring(0, actualSecretCode.indexOf("&"));
        System.out.println(actualSecretCode);
        try {
            String otp = getTotp(actualSecretCode);
            System.out.println("otp === " + otp);
            driver.findElement(By.cssSelector("label[for='verification_code'] + label + input")).sendKeys(otp);
        }catch (NoSuchElementException nse){
            driver.findElement(By.cssSelector("#mfa_code")).sendKeys(getTotp(actualSecretCode));
        }
        try{
            driver.findElement(By.cssSelector("button[aria-label='Confirm']")).click();
        }catch (NoSuchElementException nse){
            driver.findElement(By.cssSelector("button[data-hook=\"mfa-login-continue-button\"]")).click();
        }
        driver.findElement(By.cssSelector("button[aria-label='Got It']")).click();
        driver.findElement(By.cssSelector("button[aria-label=\"Accept all cookies\"]")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        driver.findElement(By.id("checkbox0")).click();
        driver.findElement(By.id("checkbox1")).click();
        driver.findElement(By.id("checkbox2")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label=\"Continue\"]")));
        driver.findElement(By.cssSelector("button[aria-label=\"Continue\"]")).click();
        driver.findElement(By.xpath("button[aria-label=\"close modal\"]/*[name='svg']")).click();
    }

    public void appium_server_start() {
        Runtime runtime;
        runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(" Unable to Launch Appium Server ");
            e.printStackTrace();
        }

        System.out.println(" Appium Server Started ");
    }

    public String getTotp(String key) {
        Totp otp = new Totp(key);
        return otp.now();
    }

    public void takeElementScreenshot(WebElement element) {
        File source = element.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") +    "/qrCode/elementLogo.png");

        try {
            FileHandler.copy(source, dest);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void readSecretCodeFromQRImage() throws NotFoundException, IOException, WriterException {
        String actualSecretCode = getQRCodeData(System.getProperty("user.dir") +    "/qrCode/elementLogo.png");
        actualSecretCode = actualSecretCode.substring(actualSecretCode.indexOf("=") + 1);
        actualSecretCode = actualSecretCode.substring(0, actualSecretCode.indexOf("&"));
        System.out.println(actualSecretCode);
    }


    public static String readQRCode(String path, String charset, Map map) throws IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }

    public static String getQRCodeData(String path) throws WriterException, IOException, NotFoundException {
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        return readQRCode(path, charset, hintMap);
    }

}
