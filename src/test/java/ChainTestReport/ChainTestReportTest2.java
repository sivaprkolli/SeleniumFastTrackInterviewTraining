package ChainTestReport;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Listeners(ChainTestListener.class)
public class ChainTestReportTest2 {

    @Test
    public void Payment() {
        ChainTestListener.log("Payment method");
        Assert.assertTrue(true);
    }

    @Test
    public void SuccessMessage(final Method method) {
        ChainTestListener.log("SuccessMessage method");
        Assert.assertTrue(false);
    }
}

