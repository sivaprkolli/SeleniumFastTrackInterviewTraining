package Assignments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class AirportCodeFromAPI {

    public static String getAirportCode(String airportName) {
        String apiKey = "b43231fe13ea81c166cd5426de96a090";  // Replace with your AviationStack API key
        String apiUrl = "http://api.aviationstack.com/v1/airports?access_key=" + apiKey + "&search=" + airportName.replace(" ", "%20");

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int status = conn.getResponseCode();
            if (status == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray data = jsonResponse.getJSONArray("data");

                if (data.length() > 0) {
                    JSONObject airport = data.getJSONObject(0);
                    return airport.getString("iata_code");
                } else {
                    return "No airport found for: " + airportName;
                }
            } else {
                return "API request failed with status: " + status;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching airport code";
        }
    }

    public static void main(String[] args) {
        String airportName = "Los Angeles International Airport";
        String iataCode = getAirportCode(airportName);
        System.out.println("IATA Code: " + iataCode);
    }
}

