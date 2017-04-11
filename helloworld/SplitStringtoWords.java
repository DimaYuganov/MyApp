package helloworld;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 * Created by 1234 on 3/17/2017.
 */
public class SplitStringtoWords {


    public static void main(String[] args) {


        try{
            Workbook wb = new HSSFWorkbook();
            //Workbook wb = new XSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("new sheet");
            Row row = sheet.createRow((short)0);
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\1234\\Downloads\\out.xls");
            wb.write(fileOut);
            fileOut.close();

        }catch (Exception e){
            System.out.println("Cant't Create a file");}


    }


}
