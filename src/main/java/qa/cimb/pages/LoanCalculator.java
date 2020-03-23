package qa.cimb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.cimb.CimbBase;

public class LoanCalculator extends CimbBase {
	
	@FindBy(linkText = "Proceed")
	WebElement proceedButton;
	
	@FindBy(xpath ="//input[@class='principal-amount numeric-only nodecimal']")
	WebElement principalValue;
	
	@FindBy(xpath = "//input[@class='loan-tenure numeric-only nodecimal']")
	WebElement loanTenure;
	
	@FindBy(linkText = "Calculate")
	WebElement calculateButton;
	
	public LoanCalculator() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProceedButton() {
		proceedButton.click();
	}
	
	public void enterLaonDeatils(String principal,String tenure) {
		
		principalValue.clear();
		principalValue.sendKeys("100000");
		
		loanTenure.clear();
		loanTenure.sendKeys(tenure);
	}
	public void clickOnCalculate() {
		
		calculateButton.click();
	}

}
