package ObjectRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CommonMethods {

	WebDriver driver;
	
	public CommonMethods(WebDriver driver)
	{
		this.driver=driver;
	}

	
	/**
	 * Description: Is Element Loaded Explicit Wait
	 */
	public void isElementLoaded(By elementToBeLoaded) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
	}
	
	/**
	 * Description: Click on path provided with Explicit Wait
	 */
	public void click(By path) throws Throwable
	{
		Thread.sleep(200);
		isElementLoaded(path);
		driver.findElement(path).click();
	}

		
	/**
	 * Description: to click Element
	 */
	public void JavaScriptClick(By Path)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement ele = driver.findElement(Path);
		jse.executeScript("arguments[0].click()", ele);
	}
	
	/**
	 * Description: Capture the Href link by providing Name of the Link, and assert if correct link is present
	 */
	public void AssertIfPresentOnPageByLinksUsingLinkText(String NameOfTheLink,String LinkToCheck)
	{
		try
		{
			String linkActual=driver.findElement(By.xpath("(//a[text()='"+NameOfTheLink+"'])[1]")).getAttribute("href").trim();	
			Assert.assertEquals(linkActual,LinkToCheck);
			//log.info(LinkToCheck + " Link is present on the screen ****PASSED****");
			System.out.println(LinkToCheck +"Link is present");
		}
		catch(NoSuchElementException | AssertionError e)
		{
			//log.error(LinkToCheck + " is not present *******FAILED*******");
			System.out.println(LinkToCheck +"Link is not present");
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
		
	}
	
	/**
	 * Description: Capture current URL and verify if correct
	 */
	public void AssertCurrentURL(String LinkToCheck)
	{
		try
		{
			String linkActual=driver.getCurrentUrl();	
			Assert.assertEquals(linkActual,LinkToCheck);
			//log.info(LinkToCheck + " Link is present on the screen ****PASSED****");
			System.out.println(LinkToCheck +"Link is present");
		}
		catch(NoSuchElementException | AssertionError e)
		{
			//log.error(LinkToCheck + " is not present *******FAILED*******");
			System.out.println(LinkToCheck +"Link is not present");
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
	}
	
	/**
	 * Description: Verify if Text Present on Page by using assert
	 */
	public void AssertIfTextPresentOnPage(String TextToCheck)
	{
		try
		{
			Boolean TrueOrFalse=driver.findElement(By.xpath("(//span[text()='"+TextToCheck+"'])")).isDisplayed();	
			Assert.assertTrue(TrueOrFalse);
			//log.info(LinkToCheck + " Link is present on the screen ****PASSED****");
			System.out.println(TextToCheck +" is present on the page");
		}
		catch(NoSuchElementException | AssertionError e)
		{
			//log.error(LinkToCheck + " is not present *******FAILED*******");
			System.out.println(TextToCheck +" is not present on the page");
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
	}
	
	/**
	 * 
	 * Description: Check if Two Text are similar (Used for capturing the date from system and verifying it with the given date.)
	 */
	public void AssertTwoTextComparison(String TextToCheck, String ActualText)
	{
		try
		{
			Assert.assertEquals(ActualText,TextToCheck);
			//log.info(LinkToCheck + " Link is present on the screen ****PASSED****");
			System.out.println(ActualText +" is present on the page");
		}
		catch(NoSuchElementException | AssertionError e)
		{
			//log.error(LinkToCheck + " is not present *******FAILED*******");
			System.out.println(ActualText +" is not present on the page");
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
	}
	
	/**
	 * 
	 * Description: Capture and return system date in format EEEEE(Day), dd(Date) MMMMM(Month)
	 */
	public String DateFromCurrentDate(int DaysFromToday)
	{
		String Pattern="EEEEE, dd MMMMM";
		DateFormat df=new SimpleDateFormat(Pattern);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, DaysFromToday);
		Date d = c.getTime();
		String DateAsString = df.format(d);
		return DateAsString;
	}
	 
}
	//endregion

