package ReadDataFromExcel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJson {
    @Test
    public void sampleTest(){
        readUserData("cookies","domain");
    }
    /**
     * Read data from json data file
     *
     * @param object json object
     * @param key key
     * @return
     */
    public static String readUserData(String object, String key) {
        String keyValue = null;
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("tricentis.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray dataList = (JSONArray) obj;
            for (Object data : dataList) {
                keyValue = getData((JSONObject) data, object, key);
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

    public static String reaCapabilities(String file, String key, String value) {
        String keyValue = null;
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file)) {
            Object obj = jsonParser.parse(reader);
            JSONArray dataList = (JSONArray) obj;
            for (Object data : dataList) {
                keyValue = getData((JSONObject) data, key, value);
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
     * Get data
     *
     * @param dataJson object
     * @param key      key
     * @param value    value
     * @return return data
     */
    public static String getData(JSONObject dataJson, String key, String value) {

        JSONObject dataObject = (JSONObject) dataJson.get(key);
        String valuePair = (String) dataObject.get(value);
        System.out.println(valuePair);
        return valuePair;
    }
}
