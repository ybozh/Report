package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.text.DateFormatter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import processing.*;;

public class EditExcelFile {
	
	public static void main(String[] args) throws IOException, Exception, InvalidFormatException {

		SimpleDateFormat dateOfReportFormat = new SimpleDateFormat("dd MMMM");
		SimpleDateFormat yearOfReportFormat = new SimpleDateFormat("yyyy року");
		
		String dateOfReport = dateOfReportFormat.format(new Date());
		String yearOfReport = yearOfReportFormat.format(new Date());
		//String codeOfReport = "BOY";
		
		CreateCodeFromDate code = new CreateCodeFromDate();
		Date date = new Date();
		String codeOfReport = code.createCodeFromDate("BOY", date);
		String nameOfUser = "Божко Юрій Володимирович";
		
		
		
		FileInputStream inp = new FileInputStream("test.xls");
	    //InputStream inp = new FileInputStream("workbook.xlsx");
	 		 	
	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    
	    final int rowIndex = 5;
	    final int cellIndex = 12;
	    Row row = sheet.getRow(rowIndex);
	    if (row == null) 
	        row = sheet.createRow(rowIndex);
	    Cell cell = row.getCell(cellIndex);
	    if (cell == null) 
	        cell = row.createCell(cellIndex);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue(dateOfReport.toString());
	    
	    final int rowIndex1 = 5;
	    final int cellIndex1 = 13;
	    row = sheet.getRow(rowIndex1);
	    if (row == null) 
	        row = sheet.createRow(rowIndex1);
	    cell = row.getCell(cellIndex1);
	    if (cell == null) 
	        cell = row.createCell(cellIndex1);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue(yearOfReport.toString());
	    
	    final int rowIndex2 = 5;
	    final int cellIndex2 = 7;
	    row = sheet.getRow(rowIndex2);
	    if (row == null) 
	        row = sheet.createRow(rowIndex2);
	    cell = row.getCell(cellIndex2);
	    if (cell == null) 
	        cell = row.createCell(cellIndex2);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue(codeOfReport);
	    
	    final int rowIndex3 = 16;
	    final int cellIndex3 = 1;
	    row = sheet.getRow(rowIndex3);
	    if (row == null) 
	        row = sheet.createRow(rowIndex3);
	    cell = row.getCell(cellIndex3);
	    if (cell == null) 
	        cell = row.createCell(cellIndex3);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue(nameOfUser);	    
	    
	    wb.getCreationHelper().createFormulaEvaluator().evaluateAll();	    
	    
	    inp.close();

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream(codeOfReport + ".xls");
	    wb.write(fileOut);
	    fileOut.close();
	 	
	
	}
	
}