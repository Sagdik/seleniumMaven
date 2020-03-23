package cimb.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import qa.cimb.CimbBase;
import qa.cimb.pages.CimbBankHomePage;
import qa.cimb.pages.LoanCalculator;
import qa.cimb.pages.ToolsPages;
import qa.cimb.utility.CustomeListner;
import qa.cimb.utility.ScrollPageUtility;

@Listeners(CustomeListner.class)
public class CimbBankTestCases extends CimbBase {

	CimbBankHomePage homePage;
	ScrollPageUtility scroll;
	ToolsPages toolsPage;
	LoanCalculator loanCalculator;
	SoftAssert softAssert;

	public CimbBankTestCases() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Parameters({"url"})
	@BeforeMethod(alwaysRun = true)
	public void openBrowser(String url) throws InterruptedException {

		//Launch the browser 
		launchBrowser(url);
		homePage = new CimbBankHomePage();
		toolsPage = new ToolsPages();
		loanCalculator = new LoanCalculator();
		scroll = new ScrollPageUtility();
		softAssert = new SoftAssert();
	}
	
	@Test
	public void cimbBankToolsTestCases() throws InterruptedException {
		
		//Wait for 15 second  for element visible
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		
		//Mouse hover on support menus
		homePage.homePageSupport();
		
		//Select tools button from menu 
		homePage.selectTool();
		
		//scroll and select loan button
		scroll.scrollPageByValue("0", "100");
		toolsPage.selectLoanCalucaltor();
		
		//Click on proceed button on coming pop-up
		loanCalculator.clickOnProceedButton();
		
		//Enter principle and tenure value
		loanCalculator.enterLaonDeatils("100000", "10");
		
		//Click on Calculate button to see values
		loanCalculator.clickOnCalculate();
		
		//Validation for loan Amount 
		String loanAmount = driver.findElement(By.xpath("//div[@class='eight columns text-right loan-amt']")).getText();
 		softAssert.assertEquals(loanAmount, "S$ 100,000");
		
 		//Validation for loan Interested
		String toralInterestAmount = driver.findElement(By.xpath("//div[@class='eight columns text-right total-interest-payable text-right']")).getText();
		softAssert.assertEquals(toralInterestAmount, "S$ 19,318");
		
		//Validation for amount payment 
		String totalAmountPayment = driver.findElement(By.xpath("//div[@class='eight columns text-right total-amt-payable']")).getText();
		softAssert.assertEquals(totalAmountPayment, "S$ 119,318");
	
		//Validation for Interested  Rate 
		String effectiveInterestedRate = driver.findElement(By.xpath("//div[@class='eight columns text-right eff-rate']")).getText();
		softAssert.assertEquals(effectiveInterestedRate, "3.62%");
		
		softAssert.assertAll();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
