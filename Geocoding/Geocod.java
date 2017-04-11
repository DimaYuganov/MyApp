package Geocoding;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by 1234 on 2/20/2017.
 */
public class Geocod {





    String region, coordinates;


    public Geocod() throws Exception {
    }




    public String[] getGeocod(String location) throws Exception {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location + "&key=AIzaSyCwABNJyZRbmNBUgx-XX-4qK9wj1G55eDY";

        final JSONObject response = JsonReader.read(url);
        String[] result=new String[2];
        try {


            JSONObject loc = response.getJSONArray("results").getJSONObject(0);
            loc = loc.getJSONObject("geometry");
            loc = loc.getJSONObject("location");
            final double lng = loc.getDouble("lng");// долгота
            final double lat = loc.getDouble("lat");// широта


            System.out.println(String.format("%f,%f", lat, lng));// итоговая широта и долгота




         //   JSONObject loc = response.getJSONArray("results").getJSONObject(0);


            JSONObject locA = response.getJSONArray("results").getJSONObject(0);


            JSONArray area = locA.getJSONArray("address_components");


            String areaLevel;
            areaLevel = "";

            for (int i = 0; i < area.length(); i++) {

                String typeOfarea = area.getJSONObject(i).getJSONArray("types").getString(0);

                if (typeOfarea.equals("administrative_area_level_1"))

                {

                    areaLevel = area.getJSONObject(i).getString("long_name");

                }

            }



            if (areaLevel.equals("")) {


                for (int i = 0; i < area.length(); i++) {

                    String typeOfarea = area.getJSONObject(i).getJSONArray("types").getString(0);

                    if (typeOfarea.equals("administrative_area_level_2"))

                    {

                        areaLevel = area.getJSONObject(i).getString("long_name");


                    }

                };


            }






            result[0]=areaLevel;

            System.out.println("Area:  " + areaLevel);


            result[1] =lat + ", " + lng;


        }catch (Exception e){System.out.println("Address not found");
        coordinates="not found";};

        return result;
    }



}


