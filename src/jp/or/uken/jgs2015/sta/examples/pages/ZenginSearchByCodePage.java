package jp.or.uken.jgs2015.sta.examples.pages;

import jp.or.uken.jgs2015.sta.commons.ui.PageIdentifiedByUrl;
import jp.or.uken.jgs2015.sta.commons.ui.controls.ButtonElement;
import jp.or.uken.jgs2015.sta.commons.ui.controls.TextBoxElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZenginSearchByCodePage extends PageIdentifiedByUrl {

	public ZenginSearchByCodePage(WebDriver _driver) {
		super(_driver);
		baseUrl = "http://zengin.ajtw.net/index03.php";
	}

	public TextBoxElement txtBankCode(){
		return findTextBoxElement(By.name("inbc"));
	}

	public TextBoxElement txtBranchCode(){
		return findTextBoxElement(By.name("insc"));
	}

	private ButtonElement btnSearch(){
		return findButtonElement(By.cssSelector("input.i75"));
	}

	public ZenginSearchByCodeResultPage doSearch() {
		btnSearch().click();
		return new ZenginSearchByCodeResultPage(driver);
	}
}
