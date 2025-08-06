package RestAssuredAPITests;

import RestAssuredPoJoDemo.PojoCustomer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperDemo {

    public static PojoCustomer jsonPojo(String jsonResponse) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonResponse, PojoCustomer.class);
    }
}
