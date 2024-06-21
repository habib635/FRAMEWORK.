package TestData;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ExcelCode {



	private static final CellType BOOLEAN = null;
	private static final CellType STRING = null;
	private static final CellType NUMERIC = null;
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;


	@DataProvider(name = "TNLogin")
	public Object[][] getTNExcelLoginData() throws Exception {
		Object[][] data = ExcelCode.readFromExcelSheetTNLogin("LoginTN");
		return data;
	}


	public static Object[][] readFromExcelSheetTNLogin(String sheetName) throws Exception {
	
		 ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");
	
		 workbook = new XSSFWorkbook(ip);
	
		sheet = workbook.getSheet(sheetName);
	
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
	
		Object[][] data = new Object[rows][cols];
		for(int i=0 ; i<rows ; i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0 ; j<cols ; j++) {
					XSSFCell cell = row.getCell(j);
					org.apache.poi.ss.usermodel.CellType celltype = cell.getCellType();

					switch(celltype) {
					case STRING:
						data[i][j] = cell.getStringCellValue();
						break;

					case NUMERIC:
						data[i][j] = Integer.toString((int)cell.getNumericCellValue());
						break;

					case BOOLEAN:
						data[i][j] = cell.getBooleanCellValue();
						break;
					}
			}
		}

		return data;

	}

	@DataProvider(name = "TNRegister")
	public Object[][] getTNExcelRegisterData() throws Exception {
		Object[][] data = ExcelCode.readFromExcelSheetTNRegister("RegisterTN");
		return data;
	}

	public static Object[][] readFromExcelSheetTNRegister(String sheetName) throws Exception {
		
			 ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");
	
			 workbook = new XSSFWorkbook(ip);
		
			sheet = workbook.getSheet(sheetName);
	
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
	
			Object[][] data = new Object[rows][cols];
			for(int i=0 ; i<rows ; i++) {
				XSSFRow row = sheet.getRow(i+1);
				for(int j=0 ; j<cols ; j++) {
						XSSFCell cell = row.getCell(j);
						org.apache.poi.ss.usermodel.CellType celltype = cell.getCellType();

						switch(celltype) {
						case STRING:
							data[i][j] = cell.getStringCellValue();
							break;

						case NUMERIC:
							data[i][j] = Integer.toString((int)cell.getNumericCellValue());
							break;

						case BOOLEAN:
							data[i][j] = cell.getBooleanCellValue();
							break;
						}
				}
			}

			return data;

		}




}
