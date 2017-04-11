package YandexGeocod;

import Geocoding.JsonReader;
import org.json.JSONObject;

/**
 * Created by 1234 on 2/20/2017.
 */
public class YGeocod {





    String region, coordinates;
   // String location = "Киев Энтузиастов 9";

    public YGeocod() throws Exception {
    }




    public String[] getGeocod(String location) throws Exception {
        String url = "https://geocode-maps.yandex.ru/1.x/?format=json&geocode=" + location + "&results=1";

        final JSONObject response = JsonReader.read(url);
        String[] result=new String[3];
        try {


            JSONObject geoObjectCollection = response.getJSONObject("response")
                    .getJSONObject("GeoObjectCollection");
                    //  .getJSONObject("Point");

            JSONObject featureMember = geoObjectCollection.getJSONArray("featureMember").getJSONObject(0);
           // .getString(0)

            JSONObject geoObject = featureMember.getJSONObject("GeoObject");

            JSONObject point = geoObject.getJSONObject("Point");
            String loc_coordinates = point.getString("pos");

            String[] coordinates = loc_coordinates.split(" ");

           System.out.println(loc_coordinates);


            JSONObject metaDataProperty = geoObject.getJSONObject("metaDataProperty")

                                                    .getJSONObject("GeocoderMetaData")
                                                    .getJSONObject("Address");

            JSONObject components = metaDataProperty.getJSONArray("Components").getJSONObject(2);

            String region = components.getString("name");

            System.out.println(region);



        result [0] = coordinates[1];
        result [1] = coordinates[0];
        result [2] = region;


        //    loc = loc.getJSONObject("geometry");
        //    loc = loc.getJSONObject("location");
        //    final double lng = loc.getDouble("lng");// долгота
        //    final double lat = loc.getDouble("lat");// широта


      //      System.out.println(String.format("%f,%f", lat, lng));// итоговая широта и долгота





        //    JSONObject locA = response.getJSONArray("results").getJSONObject(0);


       //     JSONArray area = locA.getJSONArray("address_components");


       //     String areaLevel;
//            areaLevel = "";

       //     for (int i = 0; i < area.length(); i++) {

        //        String typeOfarea = area.getJSONObject(i).getJSONArray("types").getString(0);

       //         if (typeOfarea.equals("administrative_area_level_1"))

      //          {

       //             areaLevel = area.getJSONObject(i).getString("long_name");

        //        }

        //    }









           // result[0]=areaLevel;

           // System.out.println("Area:  " + areaLevel);


           // result[1] =lat + ", " + lng;


        }catch (Exception e){System.out.println("Address not found");
            coordinates="not found";};

        return result;
    }



}


