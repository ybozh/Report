package file;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("C:/Users/Bozhko/GitProjects/Report/read.xls");
		Workbook wb = new HSSFWorkbook(fis);
		
//		String result = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
//		String str = getCellText(wb.getSheetAt(0).getRow(0).getCell(1));	
//		System.out.println(result);
//		System.out.println(str);
		
		for (Row row : wb.getSheetAt(0)) {
			for (Cell cell : row) {
				
				CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
	            System.out.print(cellRef.formatAsString());
	            System.out.print(" - ");
				
				System.out.println(getCellText(cell));				
				
			}
		}
		
		fis.close();		

	}
	
	
	public static String getCellText (Cell cell) {
		
		String result = "";		
		
		switch (cell.getCellTypeEnum()) {
        case STRING:
            result = cell.getRichStringCellValue().getString();
            break;
        case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
            	result = cell.getDateCellValue().toString();
            } else {
            	result = Double.toString(cell.getNumericCellValue());
            }
            break;
        case BOOLEAN:
        	result = Boolean.toString(cell.getBooleanCellValue());
            break;
        case FORMULA:
        	result = cell.getCellFormula().toString();
            break;
        case BLANK:
        	result = " - ";
            break;
        default:
        	result = " * ";
		}
		
		return result;
		
	}
}


