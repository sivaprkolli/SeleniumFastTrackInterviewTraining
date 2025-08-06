package RestAssuredAPITests;

import RestAssuredPoJoDemo.PojoCustomer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateBooking {

    @Test
    public void getResponse(){
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");

        //https://restful-booker.herokuapp.com/auth
        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(file)
                .when()
                .get("/booking")
                .then()
                .extract()
                .response();

        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }


    @Test
    public void createBooking(){
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");

        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(file)
                .when()
                .post("/booking")
                .then()
                .extract()
                .response();

        System.out.println(response.statusCode());
        System.out.println(response.asString());

        JsonPath jsonPath  = response.jsonPath();
        System.out.println(jsonPath.getString("booking.firstname"));
        System.out.println(jsonPath.getString("booking.lastname"));
        System.out.println(jsonPath.getString("bookingid"));

        JSONObject jsonObject = new JSONObject(response.asString());
        System.out.println(jsonObject.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"));
    }

    @Test
    public void verifyCreateBooking(){
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(file)
                .when()
                .post("/booking")
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname",equalTo("Siva"))
                .body("booking.lastname", equalTo("Reddy"));
    }

    @Test
    public void verifyPoJoCreateBooking() throws JsonProcessingException {
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");

        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(file)
                .when()
                .post("/booking")
                .then()
                .extract()
                .response();

        PojoCustomer pojoCustomer =  ObjectMapperDemo.jsonPojo(response.asString());
        System.out.println(pojoCustomer.getBooking().getFirstname());
        System.out.println(pojoCustomer.getBooking().getLastname());
        System.out.println(pojoCustomer.getBookingid());
        System.out.println(pojoCustomer.getBooking().getBookingdates().getCheckin());
        System.out.println(pojoCustomer.getBooking().getBookingdates().getCheckout());
        System.out.println(pojoCustomer.getBooking().getAdditionalneeds());
        System.out.println(pojoCustomer.getBooking().getTotalprice());
    }
}

