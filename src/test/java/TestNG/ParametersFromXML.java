package TestNG;

import org.testng.annotations.*;

public class ParametersFromXML {

    @Test
    public void verifyHomePage() {
        System.out.println("Test TestNG");
    }

    @Test
    public void login() {
        System.out.println("Login");
    }

    @Parameters({"url", "browserName", "os"})
    @BeforeSuite
    public void intializeReport(String urlLink, String browserName, String operatingSystem) {

        System.out.println("urlLink :: " + urlLink);
        System.out.println("browserName :: " + browserName);
        System.out.println("operatingSystem :: " + operatingSystem);
    }

    @Parameters("environment")
    @BeforeTest
    public void launchApplication(String env) {
        System.out.println("environment :: " + env);
    }

}
