package PayloadCreation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CreatePayload {

    @Test
    public void createPayload() throws JsonProcessingException {

        User user1 = new User("Alice", 30);
        User user2 = new User("Bob", 25);

        Address address1 = new Address("123 Main St", "Springfield");
        Address address2 = new Address("456 Elm St", "Shelbyville");

        Payload payload = new Payload(Arrays.asList(user1, user2), Arrays.asList(address1, address2));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writeValueAsString(payload);

        System.out.println(jsonPayload);

    }

}
