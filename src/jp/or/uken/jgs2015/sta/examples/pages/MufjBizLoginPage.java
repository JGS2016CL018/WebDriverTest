package jp.or.uken.jgs2015.sta.examples.pages;

import jp.or.uken.jgs2015.sta.commons.ui.PageIdentifiedByUrl;

import org.openqa.selenium.WebDriver;

public class MufjBizLoginPage extends PageIdentifiedByUrl {

	public MufjBizLoginPage(WebDriver _driver) {
		super(_driver);
		baseUrl = "https://bizstn.bk.mufg.jp/ra/cer/dfw/Login";
	}

}
