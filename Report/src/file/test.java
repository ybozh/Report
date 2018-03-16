package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class test {
	
	public static void main(String[] args) throws IOException {

		
		FileInputStream inp = new FileInputStream("test.xls");
	    //InputStream inp = new FileInputStream("workbook.xlsx");
		
		/*String str = "test.xls";
		
		FileInputStream fis = new FileInputStream(str);
		Workbook wb = new HSSFWorkbook(fis);*/
	 		 	
		Workbook wb = new HSSFWorkbook(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    final int rowIndex = 2;
	    final int cellIndex = 5;
	    Row row = sheet.getRow(rowIndex);
	    if (row == null) 
	        row = sheet.createRow(rowIndex);
	    Cell cell = row.getCell(cellIndex);
	    if (cell == null) 
	        cell = row.createCell(cellIndex);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue("my.xls");
		
		/*Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(10);
		Cell cell = row.getCell(0);
		
		System.out.println(cell);*/

		
		/*fis.close();*/
		
		

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("test5.xls");
	    wb.write(fileOut);
	    fileOut.close();
	 	
	
	}
	
}