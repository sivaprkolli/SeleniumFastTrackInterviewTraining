package RestAssuredAPITests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SamplePostReqestUsingXwww {


    @Test
    public void verifyLoginSuccessful() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded;charset=utf-8")
                .formParam("zone","Computers")
                .formParam("cost","100")
                .when()
                .post("https://jsonplaceholder.typicode.com/posts");

        String data = response.asPrettyString();
        System.out.println("response :: " + data);
    }
}
