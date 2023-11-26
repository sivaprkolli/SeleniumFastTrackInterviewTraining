package TestNG;

import AboutWebDriver.AbstractTestClassB;
import AboutWebDriver.InterfaceA;
import org.testng.annotations.Test;

public class TestA {

    @Test
    public void testA(){
        InterfaceA interfaceA = new AbstractTestClassB();
        interfaceA.testI();
    }
}
