package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

public class CreareExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet0 = wb.createSheet("Издатели");
		
		Row row = sheet0.createRow(3);
		Cell cell = row.createCell(4);
		
		cell.setCellValue(25);
		
		Sheet sheet1 = wb.createSheet("Книги");
		Sheet sheet2 = wb.createSheet("Авторы");
		
		Sheet sheet3 = wb.createSheet(WorkbookUtil.createSafeSheetName("?*:?*%:?%:"));
		
		FileOutputStream fos = new FileOutputStream("my.xls");
		
		wb.write(fos);
		fos.close();

	}

}
