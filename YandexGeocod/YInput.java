package YandexGeocod;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by 1234 on 3/28/2017.
 */
public class YInput {

    String[] result= new String[3];
    public String[] geocode = new String[3];
    public String name;



    public YInput() throws FileNotFoundException, IOException {

    }


    public String[] getResult()throws IOException {

        //result=new String[10];
        try {



            String excelFilePath = "C:\\Users\\1234\\Downloads\\in.xls";
            //  FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(new File(excelFilePath)));


            HSSFWorkbook wb = new HSSFWorkbook(fs);

            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            YGeocod yGeocod = new YGeocod();

            YOut yOut = new YOut();
            yOut.fileCreation();


            for(int i=0; i<rows; i++) {


                try {
                    String addressInitial = String.valueOf(sheet.getRow(i).getCell(1));

                    System.out.println(addressInitial);

                    name = String.valueOf(sheet.getRow(i).getCell(0));
                    String volume = String.valueOf(sheet.getRow(i).getCell(2));
                    String ad = String.valueOf(sheet.getRow(i).getCell(3));

                    geocode = yGeocod.getGeocod(addressInitial);

                //    dataToUi.helo.setText(name);


                    String coordinates = geocode[0]+", "+geocode[1];


                 yOut.setOutPutData(i,name, coordinates, addressInitial, geocode[2], volume,ad);


                }  catch(Exception e){
                    System.out.println("Geocoding OR FILE READ was failed:");

                    System.out.println(i);


                }



            }

        } catch (Exception e){

            System.out.println("From input Data Class:  "+e.getMessage());




        }




        return result;
    }




}

