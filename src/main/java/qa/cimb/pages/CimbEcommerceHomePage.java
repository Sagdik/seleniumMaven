package qa.cimb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.cimb.CimbBase;

public class CimbEcommerceHomePage extends CimbBase {

	@FindBy(xpath = "//p[contains(text(),'CIMB Deals')]")
	WebElement dealButton;

	/*
	 * Constructor for PageFactory initialization for Deals Page
	 */
	public CimbEcommerceHomePage() {

		PageFactory.initElements(driver, this);

	}

	/*
	 * Method to select the Deals Image from homePage
	 */
	public DealPage cimbDealsButton() {

		dealButton.click();
		return new DealPage();

	}
}
