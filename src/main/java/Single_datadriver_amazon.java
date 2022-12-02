

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class Single_datadriver_amazon {
	public static String value;

	public static String amazonData(String name, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\admin\\Desktop\\workbook.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(name);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		CellType ce = c.getCellType();
		if (ce.equals(CellType.STRING)) {
			value = c.getStringCellValue();
		} else if (ce.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int i = (int) d;
			// System.out.println(i);
			value = String.valueOf(i);

		}
		return (value);
	}

	public static void main(String[] args) throws IOException {
				amazonData(value, 0, 0);

	}

}
