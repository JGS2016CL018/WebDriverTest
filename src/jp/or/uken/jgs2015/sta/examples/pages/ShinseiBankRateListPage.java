package jp.or.uken.jgs2015.sta.examples.pages;

import jp.or.uken.jgs2015.sta.commons.ui.PageIdentifiedByUrl;
import jp.or.uken.jgs2015.sta.commons.ui.controls.LinkElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShinseiBankRateListPage extends PageIdentifiedByUrl {

	public ShinseiBankRateListPage(WebDriver _driver) {
		super(_driver);
		baseUrl = "http://sre.shinseibank.com/InterestRateC/rate_list.aspx";
	}

	public LinkElement lnkPD30() {
		return findLinkElement(By.linkText("パワーダイレクト円定期預金30"));
	}
}
