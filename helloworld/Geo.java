package helloworld;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.net.URL;

public class Geo {

    public static void main(String[] args) throws Exception {

        // String str = "https://maps.googleapis.com/maps/api/geocode/json?address=Киев+Энтузиастов+9&key=AIzaSyCwABNJyZRbmNBUgx-XX-4qK9wj1G55eDY";

String[] result = new String[100];
String[] lat = new String[100];
String[] lng = new String[100];

        int i=0, a=0, n=0;
                // Get a list of albums from free music archive. limit the results to 5
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=Kiev+Entuziastov+9&key=AIzaSyCwABNJyZRbmNBUgx-XX-4qK9wj1G55eDY";
                // get an instance of the json parser from the json factory
                JsonFactory factory = new JsonFactory();
                JsonParser parser = factory.createParser(new URL(url));

                // continue parsing the token till the end of input is reached
                while (!parser.isClosed()) {
                    // get the token
                    JsonToken token = parser.nextToken();
                    // if its the last token then we are done



                    if (token == null)
                        break;


                    // we want to look for a field that says dataset

                    if (JsonToken.FIELD_NAME.equals(token) && "address_components".equals(parser.getCurrentName())) {
                        // we are entering the datasets now. The first token should be
                        // start of array
                        token = parser.nextToken();


                        if (!JsonToken.START_ARRAY.equals(token)) {
                            // bail out
                            break;
                        }
                        // each element of the array is an album so the next token
                        // should be {
                        token = parser.nextToken();
                        if (!JsonToken.START_OBJECT.equals(token)) {
                            break;
                        }
                        // we are now looking for a field that says "album_title". We
                        // continue looking till we find all such fields. This is
                        // probably not a best way to parse this json, but this will
                        // suffice for this example.
                        while (true) {
                            token = parser.nextToken();
                            if (token == null)
                                break;
                           if (JsonToken.FIELD_NAME.equals(token) && "long_name".equals(parser.getCurrentName()))
                            {
                                token = parser.nextToken();
                              //  System.out.println(parser.getText());

                              try {
                                  result[i] = parser.getText();
                                  i++;
                              }
                               catch (Exception e){
                                   System.out.println("Something wrong");
                               }
                            }

                             if (JsonToken.FIELD_NAME.equals(token) && "lat".equals(parser.getCurrentName())) {
                                    token = parser.nextToken();
                                 lat[a]=parser.getText();
                                 a++;
                                    System.out.println("Lat:  "+parser.getText());

                                }
                            if (JsonToken.FIELD_NAME.equals(token) && "lng".equals(parser.getCurrentName())) {
                                token = parser.nextToken();
                                lng[n]=parser.getText();
                                n++;
                                System.out.println("lng:  "+parser.getText());
                            }




                        }


                        if(result[4]==null) {

                            System.out.println("region=" + result[2]);
                            System.out.println("Lat: " + lat[2] + "    Lng:" + lng[2]);
                        }
                        else {

                            System.out.println("region=" +result[4]);
                            System.out.println("Lat: " + lat[2] + "    Lng:" + lng[2]);
                        }


                        }
                    }

                }

            }



