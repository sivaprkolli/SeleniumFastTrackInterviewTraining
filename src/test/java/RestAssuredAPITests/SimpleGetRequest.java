package RestAssuredAPITests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SimpleGetRequest {

    @Test
    public void getUsers(){
        Response response =
                given()
                       .queryParam("helo","1")
                        .when()
                        .contentType(ContentType.JSON)
                        .get("https://reqres.in/api/users");

        System.out.println("response :: "  + response.asPrettyString());
        Assert.assertTrue(response.statusCode() == 200);

    }

    @Test
    public void getWeatherDataUsingCityName(){
        Response response =
                given()
                        .queryParam("q","Vijayawada")
                        .queryParam("appid","92b7cd2f93befceeb747ce3681981e35")
                        .when()
                        .contentType(ContentType.JSON)
                        .get("https://api.openweathermap.org/data/2.5/weather");

        System.out.println("response :: "  + response.asPrettyString());
        Assert.assertTrue(response.statusCode() == 200);

        String responseData = response.
                then()
                .extract()
                .path("name");

        float lat = response
                .then()
                        .extract()
                                .path("coord.lat");

        float lon = response
                .then()
                .extract()
                .path("coord.lon");

        String weatherDescription = response
                .then()
                .extract()
                .path("weather[0].description");

        System.out.println(weatherDescription);
        System.out.println(lat +"  :: " +  lon);

        Assert.assertEquals(responseData, "Vijayawada");
    }

    //https://airport-data.com/api/doc.php
    @Test
    public void getAirportCode(){

        String airport = getAirportName("PHX");
        System.out.println(airport);
    }

    public String getAirportName(String code){
        Response response =
                given()
                        .queryParam("iata", code)
                        .when()
                        .contentType(ContentType.JSON)
                        .get("https://airport-data.com/api/ap_info.json");
        String airportName = response.then().extract().path("name");
        System.out.println(airportName);
        return airportName;
    }
}
