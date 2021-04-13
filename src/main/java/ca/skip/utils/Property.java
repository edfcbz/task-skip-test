package ca.skip.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import ca.skip.app.enums.Language;

public class Property {

	static Properties props;
	static FileInputStream file;

	static FileInputStream file2;
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;

	public Property() {
		getPropertyFile();
	}

	private static void getPropertyFile() {
		if (props == null) {
			props = new Properties();
			try {
				file = new FileInputStream("./properties/application.properties");
				try {
					props.load(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static String getProp(String property) {
		getPropertyFile();
		return props.getProperty(property);
	}

	public static int getPropAsInt(String property) {
		getPropertyFile();
		return Integer.parseInt(getProp(property));
	}

	public static String getProp(String language, String property) {		
		String value = "";
		try {

			if (file == null | workbook == null | sheet == null) {
				file = new FileInputStream(new File("./properties/languages.xls"));
				workbook = new HSSFWorkbook(file);
				sheet = workbook.getSheetAt(0);
			}

			Iterator<Row> rowIterator = sheet.rowIterator();
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell = cellIterator.next();

			do {
				if (cell.getStringCellValue().equals(language)) {
					do {
						if (row.getCell(0).getStringCellValue().equals(property)) {
							value = row.getCell(cell.getColumnIndex()).toString();
							break;
						}
						row = rowIterator.next();
					} while (rowIterator.hasNext());

					break;
				}
				cell = cellIterator.next();
			} while (cellIterator.hasNext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

}
