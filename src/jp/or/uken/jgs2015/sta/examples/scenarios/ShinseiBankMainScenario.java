package jp.or.uken.jgs2015.sta.examples.scenarios;

import java.io.IOException;

import jp.or.uken.jgs2015.sta.commons.util.WebDriverHelper;
import jp.or.uken.jgs2015.sta.examples.pages.ShinseiBankRateListPage;
import jp.or.uken.jgs2015.sta.examples.pages.ShinseiBankTopPage;

import org.openqa.selenium.WebDriver;

public class ShinseiBankMainScenario {
	private WebDriver driver;
	private ShinseiBankTopPage topPage;
	private ShinseiBankRateListPage ratePage;

	public ShinseiBankMainScenario(WebDriver _driver) {
		driver = _driver;
		topPage = new ShinseiBankTopPage(driver);
	}

	public void 金利一覧を開く() throws IOException {
		topPage.open();
		topPage.capture("PopupTest\\Shinsei\\SS001.png");
		ratePage = topPage.openRateList();
		ratePage.activate();
		ratePage.capture("PopupTest\\Shinsei\\SS002.png");
		ratePage.lnkPD30().click();
		ratePage.capture("PopupTest\\Shinsei\\SS003.png");
		WebDriverHelper helper = new WebDriverHelper(driver);
		helper.dumpAllWindows();
		ratePage.close();
		topPage.activate();
	}
}
