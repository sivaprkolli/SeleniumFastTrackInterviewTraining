package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSampleTest {

    @DataProvider(name = "register")
    public Object[][] registerAsAdmin(){
        return new Object[][]
                {
                        {"Selenium", "4.x"},
                        {"Appium", "2.x"},
                        {"WebDriverIO", "6.x"},
                        {"RestAssured", "7.x"}
                };
    }

    @Test(dataProvider = "register")
    public void testDataProvider(String tool, String version){
        System.out.println(  tool + " :: " + version);
    }


}
