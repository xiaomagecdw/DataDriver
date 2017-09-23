package com.frame.uitl;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUitl {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook  ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static void setExcelFile(String filePath, String SheetName) throws Exception{
		
		FileInputStream ExcelFile;
		try {
			ExcelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
	}
	
	public static String getCellData(int RowNum, int ColNum)throws Exception{
		
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getCellType() ==XSSFCell.CELL_TYPE_STRING?Cell
					.getStringCellValue() +"" 
					: String.valueOf(Math.round(Cell.getNumericCellValue()));
			return CellData;
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}
	
	
	public static void setCellData(int RowNum, int ColNum, String Result)throws Exception{
		
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			
			if(Cell == null){
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			}else{
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constant.TestDataExcelFilePath);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
	}

	
	
	
	
	
	
	
	
}
