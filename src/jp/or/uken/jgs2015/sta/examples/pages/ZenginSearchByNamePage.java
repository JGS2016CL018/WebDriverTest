package jp.or.uken.jgs2015.sta.examples.pages;

import jp.or.uken.jgs2015.sta.commons.ui.PageIdentifiedByUrl;
import jp.or.uken.jgs2015.sta.commons.ui.controls.ButtonElement;
import jp.or.uken.jgs2015.sta.commons.ui.controls.TextBoxElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZenginSearchByNamePage extends PageIdentifiedByUrl {

	public ZenginSearchByNamePage(WebDriver _driver) {
		super(_driver);
		baseUrl = "http://zengin.ajtw.net/index02.php";
	}

	public TextBoxElement txtBankName() {
		return findTextBoxElement(By.name("wd"));
	}

	private ButtonElement btnSearch() {
		return findButtonElement(By.cssSelector("input.i75"));
	}

	public ZenginSearchByNameResultPage doSearch() {
		btnSearch().click();
		return new ZenginSearchByNameResultPage(driver);
	}
}
