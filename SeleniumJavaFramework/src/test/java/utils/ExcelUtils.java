package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtils {

	static String path = System.getProperty("user.dir");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	@Test(priority=1)
	public static void getData(){

		try {
			workbook = new XSSFWorkbook(path +"/excel/data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("The count is ---"+ rowcount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test(priority=2)
	public static void getCellData(){
		try {
			workbook = new XSSFWorkbook(path +"/excel/data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			String cellData = sheet.getRow(0).getCell(0).getStringCellValue();
			double cellData1 = sheet.getRow(1).getCell(1).getNumericCellValue();
			System.out.println("The value is ---"+ cellData);
			System.out.println("The value is ---"+ cellData1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	} 
}
