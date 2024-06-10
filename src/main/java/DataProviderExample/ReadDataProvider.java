/**
 * Created by Yashwanth Rao Pinninti
 * Copyright 2021 Bublup Inc.All rights reserved
 */
package DataProviderExample;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadDataProvider {

    @DataProvider(name = "newServiceTickets")
    public Object[][] getData() throws FileNotFoundException {

        JsonElement jsonData =  new JsonParser().parse(new FileReader("/Users/shiva/Documents/SeleniumInterviewFastTrackTraining/SeleniumFastTrackInterviewTraining/sampleData.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("newServiceRequests");
        List<TestDataReader> testData = new Gson().fromJson(dataSet, new TypeToken<List<TestDataReader>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }


    @DataProvider(name = "latestServiceTickets")
    public Object[][] getData1() throws IOException, ParseException {

        JsonElement jsonData = JsonParser.parseReader(new FileReader("/Users/shiva/Documents/SeleniumInterviewFastTrackTraining/SeleniumFastTrackInterviewTraining/sampleData.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("latestServiceRequests");
        List<TestDataReader> testData = new Gson().fromJson(dataSet, new TypeToken<List<TestDataReader>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}
