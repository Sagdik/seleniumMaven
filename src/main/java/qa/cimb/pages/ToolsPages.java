package qa.cimb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.cimb.CimbBase;

public class ToolsPages extends CimbBase {

	
	@FindBy(linkText = "Property Loan Repayment Calculator")
	WebElement personalLoanCalculatorButton;
	
	public ToolsPages() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectLoanCalucaltor() {
		
		personalLoanCalculatorButton.click();
	}
}
