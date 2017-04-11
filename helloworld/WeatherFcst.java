package helloworld;

import Geocoding.JsonReader;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by 1234 on 4/1/2017.
 */
public class WeatherFcst {

public String location;
   public JSONObject current;

    public WeatherFcst() {
    }

    public String getWeatherTem(String location) throws IOException {


        String url = "http://api.apixu.com/v1/current.json?key=afbf3bddce7b4e3cb1194416170104&q=" + location;

        final JSONObject response = JsonReader.read(url);

        current = response.getJSONObject("current");

       String temp_c = Double.toString(current.getDouble("temp_c"));

        System.out.println(temp_c);


        return temp_c;
    }

    public String getWeatherWind() throws IOException {

        String wind = Double.toString(current.getDouble("wind_mph"));


        return wind;
    }

    public String getWeathericon() throws IOException {

        String icon = current.getJSONObject("condition").getString("icon");


        return icon;
    }

}
