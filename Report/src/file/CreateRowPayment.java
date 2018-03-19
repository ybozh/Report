package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateRowPayment {

	public static void main(String[] args) throws Exception, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream inp = new FileInputStream("test.xls"); 
		Workbook wb = new WorkbookFactory().create(inp);
		
		Sheet sheet = wb.getSheetAt(0);
		
		int rowStartIndex = 63;		
		int num[] = {1, 2, 3, 4, 5, 6};
		String str[] = {"ldkf", "lsvk", "rot", "zmxn ", "ldkf51", "d;flkm"};
		double sum[] = {36.25, 86.45, 89.74, 40, 95, 787.25};
		boolean paidByCreditCard[] = {true, false, false, false, true, false};
		
		for (int count = rowStartIndex; count < (num.length + rowStartIndex); count++) {		
			Row row = sheet.getRow(count);
			if (row == null) {
				row = sheet.createRow(count);
			}
			Cell cell = row.getCell(0);
			if (cell == null) {
				cell = row.createCell(0);
			}
			cell.setCellValue(num[count-rowStartIndex]);
			
			Cell cell1 = row.getCell(4);
			if (cell1 == null) {
				cell1 = row.createCell(4);
			}
			cell1.setCellValue(str[count-rowStartIndex]);
			
			Cell cell2 = row.getCell(15);
			if (cell2 == null) {
				cell2 = row.createCell(15);
			}
			cell2.setCellValue(sum[count-rowStartIndex]);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			String date[] = {sdf.format(new Date()), sdf.format(new Date()), sdf.format(new Date()), sdf.format(new Date()), sdf.format(new Date()), sdf.format(new Date())};
			
			Cell cell3 = row.getCell(2);
			if (cell3 == null) {
				cell3 = row.createCell(2);
			}
			cell3.setCellValue(date[count-rowStartIndex]);
			
		}
		
		int rowStartIndexPaidByCreditCard = 28;
		int ii = 0;
		
		for (int i = 0; i < num.length; i++) {
			
			if (paidByCreditCard[i] == true) {
				
				
				Row row = sheet.getRow(rowStartIndexPaidByCreditCard + ii);
				if (row == null) {
					row = sheet.createRow(rowStartIndexPaidByCreditCard + ii);
				}
				Cell cell = row.getCell(0);
				if (cell == null) {
					cell = row.createCell(0);
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");			
				
				cell.setCellValue((ii+1) + ". " + str[i] + " (" + sdf.format(new Date()) + ")");
				
				Cell cell1 = row.getCell(7);
				if (cell1 == null) {
					cell1 = row.createCell(7);
				}
				cell1.setCellValue(sum[i]);
				ii++;
								
			}
			
		}
		
		 wb.getCreationHelper().createFormulaEvaluator().evaluateAll();	    
		    
		 inp.close();
		 
		 FileOutputStream fileOut = new FileOutputStream("result.xls");
		 wb.write(fileOut);
		 fileOut.close();

	}

}
