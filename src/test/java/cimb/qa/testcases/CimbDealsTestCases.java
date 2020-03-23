package cimb.qa.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import qa.cimb.CimbBase;
import qa.cimb.pages.DealPage;
import qa.cimb.pages.CimbEcommerceHomePage;
import qa.cimb.utility.CustomeListner;
import qa.cimb.utility.ScrollPageUtility;

@Listeners(CustomeListner.class)
public class CimbDealsTestCases extends CimbBase {

	DealPage dealPage;
	CimbEcommerceHomePage homePage;
	ScrollPageUtility scroll;
	SoftAssert softAssert;

	public CimbDealsTestCases() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Parameters({"url"})
	@BeforeMethod(alwaysRun=true)
	public void openBrowser(String url) throws InterruptedException {

		launchBrowser(url);

		dealPage = new DealPage();

		homePage = new CimbEcommerceHomePage();

		scroll = new ScrollPageUtility();
		
		softAssert = new SoftAssert();
	}

	@Test
	public void cimbDealDeatilsTestCase() throws InterruptedException, AWTException {

		scroll.scrollPageByValue("0", "800");

		//Click on cimb deals from fome page
		homePage.cimbDealsButton();

		//Click on fun and travel and select Dorsett subhang hotel
		dealPage.funAndTravelButton();
		
		//Validate the Dorsett grand subhang page
		String text = driver.findElement(By.xpath("//p[@class='detail-text-first']")).getText();
		softAssert.assertEquals(text, "TRAVEL & FUN • DORSETT GRAND SUBANG");
		
		//Validate similar product show on page
		String similarDealsText = driver.findElement(By.xpath("//p[@class='section-title pl-3']")).getText();
		softAssert.assertEquals(similarDealsText, "Similar Deals");
		
		softAssert.assertAll();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {

		driver.quit();

	}

}
