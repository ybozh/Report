package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 
public class EditExcelFile {
 
   public static void main(String[] args) throws IOException {
 
       File file = new File("my.xls");
       // Read XSL file
       FileInputStream inputStream = new FileInputStream(file);
 
       // Get the workbook instance for XLS file
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
       // Get first sheet from the workbook
       HSSFSheet sheet = workbook.getSheetAt(0);
 
       HSSFCell cell = sheet.getRow(3).getCell(4);
              
       cell.setCellValue(258);       
 
       inputStream.close();
 
       // Write File
       FileOutputStream out = new FileOutputStream(file);
       workbook.write(out);
       out.close();
 
   }
 
}