package jp.or.uken.jgs2015.sta.examples.scenarios;

import java.io.IOException;

import jp.or.uken.jgs2015.sta.commons.excelUtil.RowEx;
import jp.or.uken.jgs2015.sta.examples.pages.ZenginSearchByCodePage;
import jp.or.uken.jgs2015.sta.examples.pages.ZenginSearchByCodeResultPage;
import jp.or.uken.jgs2015.sta.examples.pages.ZenginSearchByNamePage;
import jp.or.uken.jgs2015.sta.examples.pages.ZenginSearchByNameResultPage;

import org.openqa.selenium.WebDriver;

public class ZenginSearchScenario {
	private WebDriver driver;
	private ZenginSearchByNamePage SearchByNamePage;
	private ZenginSearchByCodePage SearchByCodePage;

	public ZenginSearchScenario(WebDriver _driver) {
		driver = _driver;
		SearchByNamePage = new ZenginSearchByNamePage(driver);
		SearchByCodePage = new ZenginSearchByCodePage(driver);
	}

	/*
	 * Row(Excelシートの1行)を元に、DataDrivenTestを実行
	 */
	public boolean SearchByName(RowEx row) throws IOException {
		String id = row.cells(0).getValue();
		String bankName = row.cells(1).getValue();
		return SearchByName(id, bankName);
	}

	/*
	 * 必要な項目が多い場合は、Beansを利用することも検討してください
	 */
	public boolean SearchByName(String id, String name) throws IOException {
		String prefix = "SearchByName\\" + id;

		SearchByNamePage.open();
		SearchByNamePage.txtBankName().setText(name);
		SearchByNamePage.capture(prefix + "\\SS001_BeforeClick.png");
		ZenginSearchByNameResultPage resultPage = SearchByNamePage.doSearch();
		resultPage.capture(prefix + "\\SS002_ResultPage.png");
		System.out.println(resultPage.tblResult().dump());
		return true;
	}

	/*
	 * Row(Excelシートの1行)を元に、DataDrivenTestを実行
	 */
	public boolean SearchByCode(RowEx row) throws IOException {
		String id = row.cells("No").getValue();
		String bankCode = row.cells("金融機関コード").getValue();
		String branchCode = row.cells("支店コード").getValue();
		return SearchByCode(id, bankCode, branchCode);
	}

	/*
	 * 必要な項目が多い場合は、Beansを利用することも検討してください
	 */
	public boolean SearchByCode(String id, String bankCode, String branchCode)
			throws IOException {
		String prefix = "SearchByCode\\" + id;

		SearchByCodePage.open();
		SearchByCodePage.txtBankCode().setText(bankCode);
		SearchByCodePage.txtBranchCode().setText(branchCode);
		SearchByCodePage.capture(prefix + "\\SS001_BeforeClick.png");
		ZenginSearchByCodeResultPage resultPage = SearchByCodePage.doSearch();
		resultPage.capture(prefix + "\\SS002_ResultPage.png");
		System.out.println(resultPage.tblResult().dump());
		return true;
	}
}
