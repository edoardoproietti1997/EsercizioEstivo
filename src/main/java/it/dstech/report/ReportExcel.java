package it.dstech.report;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportExcel {
	
	private String url = "";
	
	public void connessioneExcel() {
		XSSFWorkbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet();
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		Cell cell2 = row.createCell(1);
		
	}

}
