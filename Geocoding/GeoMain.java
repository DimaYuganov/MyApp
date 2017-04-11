package Geocoding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 1234 on 2/20/2017.
 */
public class GeoMain {



    public static void main(String[] args) throws Exception{

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        System.out.println(dateFormat.format(date));

    InputData inputData = new InputData();

        inputData.getResult();

        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date1 = new Date();
        System.out.println(dateFormat.format(date1));

    }

}
