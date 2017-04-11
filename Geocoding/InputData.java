package Geocoding;

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
 * Created by 1234 on 3/15/2017.
 */
public class InputData {

    String[] result= new String[3];


    public InputData() throws FileNotFoundException, IOException {

    }

    // @FXML
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

            Geocod geocoding = new Geocod();
            OutputData outputData = new OutputData();
            outputData.fileCreation();

             StringProcess customAdd = new StringProcess();

            String add[];

for(int i=0; i<rows; i++) {


    try {
        String addressInitial = String.valueOf(sheet.getRow(i).getCell(1));
        add = customAdd.getStr(addressInitial);
        String fullAddress = "";
        System.out.println(fullAddress.replaceAll(" ", "+"));
        String address = (add[0] + " " + add[1] + " " + add[2]).replaceAll(" ", "+");
        System.out.println(address);
        String name = String.valueOf(sheet.getRow(i).getCell(0));
        String volume = String.valueOf(sheet.getRow(i).getCell(2));
        String ad = String.valueOf(sheet.getRow(i).getCell(3));

        String geocode[] = geocoding.getGeocod(address);
        outputData.setOutPutData(i,name, geocode[1], addressInitial, geocode[0], volume,ad);

        result[0]=Integer.toString(i);
        result[1]=name;
        result[2]= geocode[0] + " "+addressInitial;


    }  catch(Exception e){
        System.out.println("Geocoding OR FILE READ was failed:");

        System.out.println(i);

        result[0]=Integer.toString(i);
        result[1]="NA";
        result[2]= "NA";

    }



}

        } catch (Exception e){

            System.out.println("From input Data Class:  "+e.getMessage());




        }




        return result;
    }



    public String getname()throws IOException {


        return null;
    }
}
