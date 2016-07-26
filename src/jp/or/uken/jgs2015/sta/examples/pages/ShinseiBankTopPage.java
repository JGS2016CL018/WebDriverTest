package jp.or.uken.jgs2015.sta.examples.pages;

import jp.or.uken.jgs2015.sta.commons.ui.PageIdentifiedByUrl;
import jp.or.uken.jgs2015.sta.commons.ui.controls.LinkElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShinseiBankTopPage extends PageIdentifiedByUrl {

	public ShinseiBankTopPage(WebDriver _driver) {
		super(_driver);
		baseUrl = "http://www.shinseibank.com/";
	}

	private LinkElement lnkKinriYen() {
		return findLinkElement(By.linkText("金利一覧"));
	}

	public ShinseiBankRateListPage openRateList() {
		lnkKinriYen().click();
		ShinseiBankRateListPage newPage = new ShinseiBankRateListPage(driver);
		newPage.waitForPopup();
		return newPage;
	}
}
