package jp.or.uken.jgs2015.sta.examples.tests;

import jp.or.uken.jgs2015.sta.commons.base.SeleniumTestCase;
import jp.or.uken.jgs2015.sta.examples.pages.MufjBizLoginPage;
import jp.or.uken.jgs2015.sta.examples.pages.MufjBizTopPage;
import jp.or.uken.jgs2015.sta.examples.scenarios.ShinseiBankMainScenario;

import org.junit.Test;

public class PopupWindowTest extends SeleniumTestCase{

	@Test
	public void testOpenKinriWindow() throws Exception {
		ShinseiBankMainScenario scenario = new ShinseiBankMainScenario(driver);
		scenario.金利一覧を開く();
	}

	/*
	 * Scenarioクラスを実装しないパターン。複雑な処理でなければアリ。
	 */
	@Test
	public void testOpenLoginWindow() throws Exception {
		MufjBizTopPage topPage = new MufjBizTopPage(driver);
		topPage.open();
		topPage.capture("PopupTest\\MUFJ\\SS001.png");

		MufjBizLoginPage loginPage = topPage.openLoginWindow();
		loginPage.activate();
		loginPage.capture("PopupTest\\MUFJ\\SS002.png");
		loginPage.close();
		topPage.activate();
	}
}
