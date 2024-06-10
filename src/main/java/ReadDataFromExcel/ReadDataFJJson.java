package ReadDataFromExcel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadDataFJJson {

    @Test
    public void simpleApp() throws IOException {
        byte[] bytes;
        File file = new File(System.getProperty("user.dir")+ "/tricentis.json");
        bytes = Files.readAllBytes(file.toPath());
        System.out.println("bytes :: " + bytes.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(bytes);
        System.out.println(jsonNode.get("session_data").get("cookies").get(0).get("domain"));
    }
}
