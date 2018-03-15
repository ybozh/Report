package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class EditExcelFile {
 
   public static void main(String[] args) throws IOException {
 
       File file = new File("my3.xls");
       // Read XSL file
       FileInputStream inputStream = new FileInputStream(file);
       
       XSSFWorkbook wb = new XSSFWorkbook();
 
       // Get the workbook instance for XLS file
       //HSSFWorkbook workbook = new HSSFWorkbook(inputStream);      
 
       XSSFSheet sheet = wb.getSheetAt(0);
       
       // Get first sheet from the workbook
       //HSSFSheet sheet = workbook.getSheetAt(0);
       
       XSSFCell cell = sheet.getRow(3).getCell(4);
       
       //HSSFCell cell = sheet.getRow(3).getCell(5);
       cell.setCellValue(909);
       
       
       
       
             
 
       inputStream.close();
 
       // Write File
       FileOutputStream out = new FileOutputStream(file);
       wb.write(out);
       out.close();
 
   }
	   
	   
 
}