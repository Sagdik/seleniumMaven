package qa.cimb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.cimb.CimbBase;

public class CimbBankHomePage extends CimbBase {

	@FindBy(xpath = "//ul[@class='header-secondary-items']//a[contains(text(),'Support')]")
	WebElement support;
	
	@FindBy(xpath = "//a[contains(text(),'Tools »')]")
	WebElement tools;
	
	
	public CimbBankHomePage() {
		
		PageFactory.initElements(driver, this);
	
	}
	
	public void homePageSupport() throws InterruptedException {
	
		Actions action = new Actions(driver);
		action.moveToElement(support).build().perform();
		
		Thread.sleep(5000);
		//tools.click();
	}
	
	public void selectTool() {
		tools.click();
	}
	
	
}
