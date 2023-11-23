package TestNG;

import org.testng.annotations.*;

public class BasicsOfTestNG {


    @Test
    public void verifyHomePage(){
        System.out.println("Test TestNG");
    }

    @Test
    public void login(){
        System.out.println("Login");
    }
    @BeforeSuite
    public void intializeReport(){
        System.out.println("Report is Intialized/DataBase Connectivity/Driver Initialization");
    }

    @BeforeTest
    public void launchApplication(){
        System.out.println("launch Application");
    }

    @BeforeClass
    public void dependenciesOfTheClass(){
        System.out.println("Intialize Pages");
    }

    @BeforeMethod
    public void preRequisiteOfTheTest(){
        System.out.println("For every Test");
    }

    @AfterSuite
    public void killSession(){
        System.out.println("Generate final report");
    }

    @AfterTest
    public void killBrowser(){
        System.out.println("Close Browsers");
    }

    @AfterClass
    public void closeDataBaseOrClosefiles(){
        System.out.println("Close files");
    }

    @AfterMethod
    public void postRequestAfterTest(){
        System.out.println("After every test");
    }

}
