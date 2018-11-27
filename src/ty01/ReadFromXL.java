package ty01;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

public class ReadFromXL {

	public static void main(String[] args) {
//		String v="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream("Read.xlsx"));
			Cell v=w.getSheet("Sheet1").getRow(1).getCell(1);
			String s = v.toString();
			CellReference cr=new CellReference("ABC");
			System.out.println();
//			System.out.println(v.getColumnIndex());
			}
		catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(v);

	}

}
