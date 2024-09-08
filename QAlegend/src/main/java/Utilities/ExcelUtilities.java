package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
           
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;
	
	public static String getString(int i,int j,String filepath,String sheet) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		Row r=sh.getRow(i);
		org.apache.poi.ss.usermodel.Cell c=r.getCell(j);
		return c.getStringCellValue();
	}
	
	public static String getNumeric(int i,int j,String filepath,String sheet) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		Row r=sh.getRow(i);
		org.apache.poi.ss.usermodel.Cell c=r.getCell(j);
		int value=(int)c.getNumericCellValue();
		return String.valueOf(value);
	}
}
