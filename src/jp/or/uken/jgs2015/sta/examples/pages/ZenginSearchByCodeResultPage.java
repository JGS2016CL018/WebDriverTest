package jp.or.uken.jgs2015.sta.examples.pages;

import jp.or.uken.jgs2015.sta.commons.ui.PageIdentifiedByUrl;
import jp.or.uken.jgs2015.sta.commons.ui.controls.TableElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZenginSearchByCodeResultPage extends PageIdentifiedByUrl {

	public ZenginSearchByCodeResultPage(WebDriver _driver) {
		super(_driver);
		baseUrl = "http://zengin.ajtw.net/search.php";
		waitForLoading();
	}

	public TableElement tblResult(){
		return new TableElement(driver, By.cssSelector("table.tbl1"));
	}

}
