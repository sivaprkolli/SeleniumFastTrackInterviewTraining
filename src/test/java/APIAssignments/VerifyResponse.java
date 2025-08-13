package APIAssignments;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class VerifyResponse {

    @Test
    public void testGETVerifyResponse() throws JsonProcessingException {
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");
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

        System.out.println(response.asString());
        System.out.println(response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray(response.asString());
        System.out.println(jsonArray.getJSONObject(0));
        System.out.println(jsonArray.getJSONObject(0).get("bookingid"));
    }

    @Test
    public void testPOSTVerifyResponse(){
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");

        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(file)
                .when()
                .post("/booking")
                .then()
                .extract().response();

        System.out.println(response.asString());
        JsonPath jsonPath = new JsonPath(response.asString());

        System.out.println(jsonPath.getString("bookingid"));
        System.out.println(jsonPath.getString("booking"));
        System.out.println(jsonPath.getString("booking.lastname"));
        System.out.println(jsonPath.getString("booking.bookingdates"));
        System.out.println(jsonPath.getString("booking.bookingdates.checkin"));
    }

    @Test
    public void testFormDataRequest() {
        Response response = RestAssured
                .given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType("application/x-www-form-urlencoded;charset=utf-8")
                .formParam("zone", "computers")
                .formParam("cost", "200")
                .when()
                .post("/posts")
                .then()
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void usingSpecBuilders(){
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");
        RequestSpecification requestSpecBuilder;
        ResponseSpecification responseSpecBuilder;

        requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                //.setBasePath("/booking")
                .setBody(file)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();

        responseSpecBuilder = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .expectBody("booking.firstname",equalTo("siva"))
                .build();


         RestAssured
                .given()
                .spec(requestSpecBuilder)
                .when()
                 .post("/booking")
                .then()
                .spec(responseSpecBuilder);





    }
}
