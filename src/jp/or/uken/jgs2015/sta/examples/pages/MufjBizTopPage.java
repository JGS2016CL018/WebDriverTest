package jp.or.uken.jgs2015.sta.examples.pages;

import jp.or.uken.jgs2015.sta.commons.ui.PageIdentifiedByUrl;
import jp.or.uken.jgs2015.sta.commons.ui.controls.LinkElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MufjBizTopPage extends PageIdentifiedByUrl {

	public MufjBizTopPage(WebDriver _driver) {
		super(_driver);
		baseUrl = "https://bizstation.bk.mufg.jp/index.html";
	}

	private LinkElement lnkLoginWin() {
		return findLinkElement(By
				.cssSelector("div.lNavDfwLoginMenu.mt10 > ul > li > a"));
	}

	public MufjBizLoginPage openLoginWindow() {
		lnkLoginWin().click();
		MufjBizLoginPage newPage = new MufjBizLoginPage(driver);
		newPage.waitForPopup();
		return newPage;
	}
}
