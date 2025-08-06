package RestAssuredAPITests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UsingSpecBuilders {
    public RequestSpecification requestSpecBuilder;
    public ResponseSpecification responseSpecBuilder;

    @BeforeTest
    public void verifyResponse(){
        File file = new File("C:\\Users\\Siva\\IdeaProjects\\SeleniumFastTrackInterviewTraining\\testData\\sample.json");
         requestSpecBuilder =  new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                //.setBasePath("/booking")
                 .setBody(file)
                 .setContentType("application/json")
                .build();

         responseSpecBuilder = new ResponseSpecBuilder()
                 .expectContentType("application/json")
                 .expectStatusCode(200)
                 .expectBody("booking.firstname",equalTo("Siva"))
                 .build();
    }

    @Test
    public void testSpec(){
        RestAssured
                .given()
                .spec(requestSpecBuilder)
                .when()
                .post("/booking")
                .then()
                .spec(responseSpecBuilder);
        //System.out.println(response.toString());
    }
}
