package Wyvaa.onemyle.GenericUtils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	/*
	 * method to get the number of rows present in the sheet
	 * @path = excel file path
	 * @sheetName = sheet name of the excel file
	 * @return = int
	 */
	public static int getRowCount(String path, String sheetName) throws Exception {

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getPhysicalNumberOfRows();
	}

	/*
	 * method to get the number of columns present in the sheet
	 * @path = excel file path
	 * @sheetName = sheet name of the excel file
	 * @return = int
	 */
	public static int getColumnCount(String path, String sheetName) throws Exception {

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	/*
	 * method to get the String value present in the Cell
	 * @path = excel file path
	 * @sheetName = sheet name of the excel file
	 * @i = row number
	 * @j = Column number
	 * @return = String
	 */
	public static String getStringValue(String path, String sheetName, int i, int j) throws Exception {

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(i).getCell(j).getStringCellValue();
	}
	
	/*
	 * method to get the Numeric value present in the Cell
	 * @path = excel file path
	 * @sheetName = sheet name of the excel file
	 * @i = row number
	 * @j = Column number
	 * @return = double
	 */
	public static double getIntegerValue(String path, String sheetName, int i, int j) throws Exception {

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(i).getCell(j).getNumericCellValue();
	}
	
	/*
	 * method to get the Numeric value present in the Cell
	 * @path = excel file path
	 * @sheetName = sheet name of the excel file
	 * @i = row number
	 * @j = Column number
	 * @return = boolean
	 */
	public static boolean getBooleanValue(String path, String sheetName, int i, int j) throws Exception {

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(i).getCell(j).getBooleanCellValue();
	}

}
