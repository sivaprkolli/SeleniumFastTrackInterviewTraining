package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelExecutions {
    @Test(groups = {"smoke", "regression"})
    public void login(){
        Assert.assertTrue(true);
        System.out.println("Login Success");
    }

    @Test(groups = "smoke")
    public void submitFrom(){
        System.out.println("Form submitted");
        Assert.assertTrue(true);
    }

    @Test(groups = "regression")
    public void selectItemsAndAddToCart(){
        System.out.println("Item Added To Cart");
        Assert.assertEquals(10, 10);
    }

    @Test(groups = {"smoke", "regression"})
    public void completePayment(){
        Assert.assertEquals("Test","Test");
        System.out.println("Payment Completed");
    }
}
