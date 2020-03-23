package qa.cimb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.cimb.CimbBase;
import qa.cimb.utility.ScrollPageUtility;

public class DealPage extends CimbBase {

	ScrollPageUtility scroll;

	@FindBy(xpath = "//app-header//li[5]//a[1]")
	WebElement travelAndFun;

	WebElement subhang;

	/*
	 * Constructor for PageFactory initialization for Deals Page
	 */
	public DealPage() {

		PageFactory.initElements(driver, this);
	}

	/*
	 * Method to select the fun and Travel and select Dorset Grand Subhang
	 */
	public void funAndTravelButton() throws InterruptedException {

		travelAndFun.click();
		//Need to Add some Explicit  Wait Page take time to load Data
		Thread.sleep(2000);
		driver.findElement(By.id("sortingDropdown")).click();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'Oldest')]")).click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;

		try {
			jsx.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
			subhang = driver.findElement(By.xpath("//p[contains(text(),'Dorsett Grand Subang')]"));
			jsx.executeScript("arguments[0].scrollIntoView();", subhang);

		} catch (Exception e) {
			/**
			 * if in any condition scroll will fail condition came in catch to scroll the
			 * page up and again load the page
			 */
			jsx.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
			jsx.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
			subhang = driver.findElement(By.xpath("//p[contains(text(),'Dorsett Grand Subang')]"));
			jsx.executeScript("arguments[0].scrollIntoView();", subhang);
		}

		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		subhang.click();

	}

}
