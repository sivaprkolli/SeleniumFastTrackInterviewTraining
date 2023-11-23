package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityAndDependencies {

    // Never use priority in the projects
    //(priority = 1)
    @Test(priority = 1)
    public void login(){
        Assert.assertTrue(true);
        System.out.println("Login Success");
    }

    @Test(dependsOnMethods = "login")
    public void submitFrom(){
        Assert.assertTrue(false);
        System.out.println("Form submitted");
    }

    @Test(dependsOnMethods = "submitFrom")
    public void selectItemsAndAddToCart(){
        Assert.assertEquals(10, 10);
        System.out.println("Item Added To Cart");
    }

    @Test(priority = 2)
    public void completePayment(){
        Assert.assertEquals("Test","Test");
        System.out.println("Payment Completed");
    }
}
