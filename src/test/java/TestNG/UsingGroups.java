package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingGroups {

    @Test(groups = {"smoke", "regression"})
    public void login(){
        Assert.assertTrue(true);
        System.out.println("Login Success");
    }

    @Test(groups = "smoke")
    public void submitFrom(){
        Assert.assertTrue(true);
        System.out.println("Form submitted");
    }

    @Test(groups = "regression")
    public void selectItemsAndAddToCart(){
        Assert.assertEquals(10, 10);
        System.out.println("Item Added To Cart");
    }

    @Test(groups = {"smoke", "regression"})
    public void completePayment(){
        Assert.assertEquals("Test","Test");
        System.out.println("Payment Completed");
    }
}
