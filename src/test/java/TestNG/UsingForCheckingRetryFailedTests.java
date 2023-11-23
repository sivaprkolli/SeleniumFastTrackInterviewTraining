package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingForCheckingRetryFailedTests {
    @Test(groups = {"smoke", "regression"})
    public void login(){
        Assert.assertTrue(true);
        System.out.println("Login Success");
    }

    @Test(groups = "smoke")
    public void submitFrom(){
        System.out.println("Form submitted");
        Assert.assertTrue(false);
    }

    @Test(groups = "regression")
    public void selectItemsAndAddToCart(){
        System.out.println("Item Added To Cart");
        Assert.assertEquals(10, 11);
    }

    @Test(groups = {"smoke", "regression"})
    public void completePayment(){
        Assert.assertEquals("Test","Test");
        System.out.println("Payment Completed");
    }
}
