package ChainTestReport;


import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Listeners(ChainTestListener.class)
public class ChainTestReportTest {

    @Test
    public void Login() {
        ChainTestListener.log("Login method");
        Assert.assertTrue(true);
    }

    @Test
    public void register(final Method method) {
        ChainTestListener.log("Register method");
        Assert.assertTrue(false);
    }
}

