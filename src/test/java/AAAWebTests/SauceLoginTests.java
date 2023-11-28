package AAAWebTests;

import Automation.AAABase;
import AAAWebPages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceLoginTests extends AAABase {

    public LoginPage loginPage;

    @BeforeClass
    public void initializePages(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyUsingValidCredentials(){
        loginPage.login("standard_user","secret_sauce", 5);
       // loginPage.login();
    }
}
