package jp.or.uken.jgs2015.sta.examples.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.or.uken.jgs2015.sta.commons.excelUtil.SheetEx;
import jp.or.uken.jgs2015.sta.commons.excelUtil.WorkbookEx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class ExcelFileIOTest {
	private static String INPUT_FILE = "inputData/TestData.xls";

	public ExcelFileIOTest() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Test
	public void ReadSheetTest() throws Exception
	{
		WorkbookEx wb = new WorkbookEx().open(INPUT_FILE);
		SheetEx ws = wb.getSheet("コード検索");

		for (Row row : ws) {
			for (Cell cell : row) {
				System.out.print(cell.toString());
				System.out.print(",");
			}
			System.out.println();
		}

		wb.close();
	}

	@Test
	public void ReadCellByIndexTest() throws Exception
	{
		WorkbookEx wb = new WorkbookEx().open(INPUT_FILE);
		SheetEx ws = wb.getSheet("コード検索");

		assertThat(ws.cells(0, 1).getValue(), is("金融機関コード"));
		assertThat(ws.cells(1, 0).getValue(), is("Case0001"));
		assertThat(ws.cells(1, 2).getValue(), is(""));
		assertThat(ws.cells(3, 1).getValue(), is("0005"));

		wb.close();
	}

	@Test
	public void ReadCellByNameTest() throws Exception
	{
		/*
		HashMap<String, Integer> map = new HashMap<String, Integer>(){
			{
				put("No", 0);
				put("金融機関コード", 1);
				put("支店コード", 2);
				put("結果", 3);
			}
		};
		*/

		WorkbookEx wb = new WorkbookEx().open(INPUT_FILE);
		SheetEx ws = wb.getSheet("コード検索", 0);

		assertThat(ws.cells(1, "支店コード").getValue(), is(""));
		assertThat(ws.cells(3, "金融機関コード").getValue(), is("0005"));
		assertThat(ws.cells(3, "支店コード").getValue(), is("135"));

		wb.close();
	}

	@Test
	public void WriteCellByIndexTest() throws Exception
	{
		WorkbookEx wb = new WorkbookEx().open(INPUT_FILE);
		SheetEx ws = wb.getSheet("コード検索");

		ws.cells(1, 3).setValue("pass");
		assertThat(ws.cells(1, 3).getValue(), is("pass"));
		ws.cells(1, 3).setValue("123");
		assertThat(ws.cells(1, 3).getValue(), is("123"));
		ws.cells(1, 3).setValue("");
		assertThat(ws.cells(1, 3).getValue(), is(""));

		wb.save();
		wb.close();
	}

}
