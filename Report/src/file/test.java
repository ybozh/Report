package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class test {
	
	public static void main(String[] args) throws IOException, Exception, InvalidFormatException {

	
	 FileInputStream inp = new FileInputStream("my5.xls");
	    //InputStream inp = new FileInputStream("workbook.xlsx");

	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    Row row = sheet.getRow(1);
	    if (row == null) 
	        row = sheet.createRow(1);
	    Cell cell = row.getCell(1);
	    if (cell == null) 
	        cell = row.createCell(1);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue("a test");

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("my7.xls");
	    wb.write(fileOut);
	    fileOut.close();
	
	}
	
}