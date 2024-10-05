package Utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

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
	public static ArrayList<String> getString(String filepath,String sheet,int rownum) throws IOException {//polymorphism
		f=new FileInputStream(System.getProperty("user.dir")+filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		ArrayList<String>excelRows=new ArrayList<String>();
		Row r=sh.getRow(rownum);
		int cellcount=r.getLastCellNum();
		for(int j=0;j<cellcount;j++){
			excelRows.add(r.getCell(j).getStringCellValue());
		}
		return excelRows;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      		}
}
