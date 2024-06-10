package DataProviderExample;

import org.testng.annotations.Test;

public class SampleTest {

    @Test(dataProvider = "newServiceTickets", dataProviderClass = ReadDataProvider.class, description = "TC-0001")
    public void dataProviderExample(TestDataReader dataProvider){

        System.out.println(dataProvider.getPropertyType() + " ::" + dataProvider.getRequestType() + " ::" + dataProvider.getProblemType());
    }


    @Test(dataProvider = "latestServiceTickets", dataProviderClass = ReadDataProvider.class, description = "TC-0002")
    public void dataProviderExample2(TestDataReader dataProvider){

        System.out.println(dataProvider.getPropertyType() + " ::" + dataProvider.getRequestType() + " ::" + dataProvider.getProblemType());
    }
}
