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
import org.omg.CORBA.PUBLIC_MEMBER;

public class test {
	
	public static void main(String[] args) throws IOException, Exception, InvalidFormatException {

		for (int i = 101; i<1000; i++) {
	 FileInputStream inp = new FileInputStream("my5.xls");
	    //InputStream inp = new FileInputStream("workbook.xlsx");
	 		 	
	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    final int rowIndex = 0;
	    final int cellIndex = 0;
	    Row row = sheet.getRow(rowIndex);
	    if (row == null) 
	        row = sheet.createRow(rowIndex);
	    Cell cell = row.getCell(cellIndex);
	    if (cell == null) 
	        cell = row.createCell(cellIndex);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue("my" + i + ".xls");

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("my" + i + ".xls");
	    wb.write(fileOut);
	    fileOut.close();
	 	}
	
	}
	
}