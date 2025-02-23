package readDataFromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	public static String readTestDataFromExcel(String path , String sheetname , int row , int col) throws IOException {
		
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(stream);
		XSSFSheet sheet= wb.getSheet(sheetname);
		String data=sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
}
