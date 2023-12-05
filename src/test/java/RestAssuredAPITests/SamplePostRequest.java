package RestAssuredAPITests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SamplePostRequest {

    public String loginRequestBody() {
        JSONObject login = new JSONObject();
        login.put("email", "eve.holt@reqres.in");
        login.put("password", "cityslicka");
        String data = login.toString();
        System.out.println(data);
        return data;
    }


    @Test
    public void verifyLoginSuccessful() {
        Response response = given()
                .when()
                .body(loginRequestBody())
                .contentType(ContentType.JSON)
                .post("https://reqres.in/api/login");

        String data = response.asPrettyString();
        System.out.println("resonse :: " + data);

        String token = response
                .then()
                .extract()
                .path("token");

        System.out.println("token :: " + token);
    }
}
