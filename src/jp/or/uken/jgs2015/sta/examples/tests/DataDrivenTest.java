package jp.or.uken.jgs2015.sta.examples.tests;

import java.nio.file.Path;

import jp.or.uken.jgs2015.sta.commons.base.SeleniumTestCase;
import jp.or.uken.jgs2015.sta.commons.excelUtil.RowEx;
import jp.or.uken.jgs2015.sta.commons.excelUtil.SheetEx;
import jp.or.uken.jgs2015.sta.commons.excelUtil.WorkbookEx;
import jp.or.uken.jgs2015.sta.commons.util.Config;
import jp.or.uken.jgs2015.sta.examples.scenarios.ZenginSearchScenario;

import org.apache.poi.ss.usermodel.Row;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataDrivenTest extends SeleniumTestCase {
	private static String INPUT_FILE = "inputData/TestData.xls";
	private static WorkbookEx book;

	@BeforeClass
	public static void setUp() throws Exception {
		book = new WorkbookEx().open(INPUT_FILE);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		Path outputFileName = new Config().evidenceSavePath().resolve("TestData.xls");
		book.saveAs(outputFileName.toString());
	}

	/*
	 * ヘッダのないExcelシートを利用する際のサンプル
	 * 項目はindexで指定
	 */
	@Test
	public void testBankCodeSearchByName() throws Exception {
		SheetEx sheet = book.getSheet("名前検索");
		ZenginSearchScenario scenario = new ZenginSearchScenario(driver);
		for (Row row : sheet){
			RowEx rowEx = new RowEx(sheet, row);
			if (!rowEx.isBody()){
				continue;
			}
			if (scenario.SearchByName(rowEx)){
				rowEx.cells(2).setValue("pass");
			}else{
				rowEx.cells(2).setValue("fail");
			}
		}
	}

	/*
	 * ヘッダ付きのExcelシートを利用する際のサンプル
	 * 項目は列名(ヘッダで指定された名前)で指定
	 */
	@Test
	public void testBankCodeSearchByCode() throws Exception {
		SheetEx sheet = book.getSheet("コード検索", 1);
		ZenginSearchScenario scenario = new ZenginSearchScenario(driver);
		for (Row row : sheet){
			RowEx rowEx = new RowEx(sheet, row);
			if (!rowEx.isBody()){
				continue;
			}
			if (scenario.SearchByCode(rowEx)){
				rowEx.cells("結果").setValue("pass");
			}else{
				rowEx.cells("結果").setValue("fail");
			}
		}
	}
}
