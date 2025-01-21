package MFA;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadQRCodeFromImage {
    @Test
    public void readSecretCodeFromQRImage() throws NotFoundException, IOException, WriterException {
        String actualSecretCode = getQRCodeData(System.getProperty("user.dir") +    "/qrCode/elementLogo.jpg");
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
