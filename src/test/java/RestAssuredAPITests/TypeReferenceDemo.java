package RestAssuredAPITests;

import RestAssuredPoJoTM.Booking;
import RestAssuredPoJoTM.BookingItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TypeReferenceDemo {

    @Test
    public void getResponse() throws JsonProcessingException {
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");

        //https://restful-booker.herokuapp.com/auth
        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/booking")
                .then()
                .extract()
                .response();

        System.out.println(response.statusCode());
        System.out.println(response.asString());

        ObjectMapper objectMapper = new ObjectMapper();
        List<BookingItem> booking = objectMapper.readValue(response.asString(), new TypeReference<>() {
        });
        System.out.println(booking.get(0).getBookingid());


    }
}
