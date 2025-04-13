package readDataFromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	
	
   public  static void writexceldata(String path , String sheetname , int row , int col , String data) throws IOException {
	   File file = new File(path);
	    FileInputStream stream = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(stream);
	    XSSFSheet sheet = wb.getSheet(sheetname);

	    // Create row if it doesn't exist
	    if (sheet.getRow(row) == null) {
	        sheet.createRow(row);
	    }

	    // Create cell if it doesn't exist
	    if (sheet.getRow(row).getCell(col) == null) {
	        sheet.getRow(row).createCell(col);
	    }

	    // Write data to the cell
	    sheet.getRow(row).getCell(col).setCellValue(data);

	    // Close the input stream and write changes to the file
	    stream.close();
	    FileOutputStream outputStream = new FileOutputStream(file);
	    wb.write(outputStream);
	    wb.close();
	    outputStream.close();
	}
		
   
	}
	
	
	

