package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtility {
	/**
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelData(String sheetname, int rownum, int cellnum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String Value=cell.getStringCellValue();
		return Value;

	}
	/**
	 * 
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] getExcelData(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data= new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}
	/**
	 * This mehod is used to write the data inside the Excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writeExcelData(String sheetname,int rownum,int column,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb=WorkbookFactory.create(fis);
		wb.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstant.EXCELPATH);
		wb.write(fos);

		
	}
	
	
	

}
