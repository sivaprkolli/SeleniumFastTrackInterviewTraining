package MFA;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ReadQRCodeDataFromBrowser {
    WebDriver driver;
    @Test
    public void getOtp() throws IOException, NotFoundException, InterruptedException {
        driver = new ChromeDriver();
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
        String actualSecretCode = textInQRCode;
        actualSecretCode = actualSecretCode.substring(actualSecretCode.indexOf("=") + 1);
        actualSecretCode = actualSecretCode.substring(0, actualSecretCode.indexOf("&"));
        System.out.println(actualSecretCode);
    }
}
