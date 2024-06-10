/**
 * Created by Yashwanth Rao Pinninti
 * Copyright 2021 Bublup Inc.All rights reserved
 */
package DataProviderExample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class TestData {


    @Test
    public void simpleApp() throws IOException {


        byte[] bytes;
        File file = new File(System.getProperty("user.dir")+ "/testData/sample.json");
        bytes = Files.readAllBytes(file.toPath());

        System.out.println("bytes :: " + bytes);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(bytes).get(0).get("contacts").get("type");
        System.out.println(jsonNode.toPrettyString());
    }



    /**
     * This method is to read data from the json file
     * @param key
     * @param value
     */
    public static String readData(String key, String value) {
        String keyValue = null;
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/testData/testData.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray dataList = (JSONArray) obj;
            for(Object emp: dataList) {
                keyValue = getData((JSONObject) emp, key, value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return keyValue;
    }

    /**
     * This method will fetch the value from the test data file
     * @param data
     * @param key
     * @param value
     */
    public static String getData(JSONObject data, String key, String value) {
        JSONObject dataObject = (JSONObject) data.get(key);
        String testData = (String) dataObject.get(value);
        System.out.println(testData);
        return testData;
    }

}
