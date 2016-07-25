package jp.or.uken.jgs2015.sta.examples.pages;

import jp.or.uken.jgs2015.sta.commons.ui.PageIdentifiedByUrl;
import jp.or.uken.jgs2015.sta.commons.ui.controls.TableElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZenginSearchByNameResultPage extends PageIdentifiedByUrl {

	public ZenginSearchByNameResultPage(WebDriver _driver) {
		super(_driver);
		baseUrl = "http://zengin.ajtw.net/ginkoukw.php";
		waitForLoading();
	}

	public TableElement tblResult(){
		return new TableElement(driver, By.cssSelector("table.tbl1"));
	}

}
