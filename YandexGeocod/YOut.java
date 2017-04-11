package YandexGeocod;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 1234 on 3/30/2017.
 */
public class YOut {



    public YOut()throws Exception {



    }

    public void setOutPutData(int i, String name, String geocode, String address, String area, String volume, String ad  ) throws IOException {

        String excelFilePath = "C:\\Users\\1234\\Downloads\\out.xls";
        //  FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(new File(excelFilePath)));


        HSSFWorkbook wb = new HSSFWorkbook(fs);
        CreationHelper createHelper = wb.getCreationHelper();
        HSSFSheet sheet = wb.getSheetAt(0);
        // HSSFRow row;
        // HSSFCell cell;

        // Create a row and put some cells in it. Rows are 0 based.

        Row row = sheet.createRow((short)i+1);
        // Create a cell and put a value in it.


        String str1="[ '"+name+"', "+geocode+", '"+ad+"', '"+address+"', '"+area+"' ],";

        //  row.createCell(1).setCellValue(1.2);
        row.createCell(1).setCellValue(createHelper.createRichTextString(name));
        row.createCell(2).setCellValue(createHelper.createRichTextString(geocode));
        row.createCell(3).setCellValue(createHelper.createRichTextString(address));
        row.createCell(4).setCellValue(createHelper.createRichTextString(area));
        row.createCell(5).setCellValue(volume);
        row.createCell(6).setCellValue(createHelper.createRichTextString(str1));
        row.createCell(7).setCellValue(createHelper.createRichTextString(ad));


        System.out.println(i);
        System.out.println(name+"  "+geocode+"  "+address+"  "+area);

        //   String str = name+"  "+geocode+"  "+address+"  "+area;
        // Write the output to a file
        //   sheet.createRow((short)5).createCell(4).setCellValue(createHelper.createRichTextString(str));


        // sheet.createRow(5).createCell(5).setCellValue(createHelper.createRichTextString(area));
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\1234\\Downloads\\out.xls");
        wb.write(fileOut);
        fileOut.close();

    }



    public void fileCreation() throws Exception{

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
