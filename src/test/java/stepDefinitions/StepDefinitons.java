package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ObjectRepository.BBCHomePage;
import ObjectRepository.BBCSearchPage;
import ObjectRepository.CommonMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import resources.base;

@RunWith(Cucumber.class)
public class StepDefinitons extends base {
	public WebDriver driver;

	@Given("^Initialise Driver$")
	public void Initialise_Driver() throws Throwable {
		System.out.println("*******TEST EXECUTION STARTED*******");
		Thread.sleep(3000);
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@And("^Navigate to WebSite$")
	public void navigate_to_BBC_Site() throws Throwable
	{
		BBCHomePage BBCHomePage = new BBCHomePage(driver);
		driver.get("https://www.bbc.com");
		BBCHomePage.popupclick();
		BBCHomePage.cookiesclick();
	}

	@And("^Verify top navigation links$")
	public void verify_top_navigation_links() throws InterruptedException 
	{
		CommonMethods commonpage=new CommonMethods(driver);
		commonpage.AssertIfPresentOnPageByLinksUsingLinkText("Home", "https://www.bbc.com/");
		commonpage.AssertIfPresentOnPageByLinksUsingLinkText("News", "https://www.bbc.com/news");
		commonpage.AssertIfPresentOnPageByLinksUsingLinkText("Sport", "https://www.bbc.com/sport");
		commonpage.AssertIfPresentOnPageByLinksUsingLinkText("Reel", "https://www.bbc.com/reel");
		commonpage.AssertIfPresentOnPageByLinksUsingLinkText("Worklife", "https://www.bbc.com/worklife");
		commonpage.AssertIfPresentOnPageByLinksUsingLinkText("Travel", "https://www.bbc.com/travel");
		commonpage.AssertIfPresentOnPageByLinksUsingLinkText("Future", "https://www.bbc.com/future");
		commonpage.AssertIfPresentOnPageByLinksUsingLinkText("Culture", "https://www.bbc.com/culture");
		Thread.sleep(3000);
	}

	@And("^Navigate to News Section$")
	public void navigate_to_news_section() throws Throwable
	{
		BBCHomePage BBCHomePage = new BBCHomePage(driver);
		BBCHomePage.newsclick();
	}

	@And("^Verify News section URL$")
	public void verify_news_section_url()
	{
		CommonMethods commonpage=new CommonMethods(driver);
		commonpage.AssertCurrentURL("https://www.bbc.com/news");
	}

	@And("^Search in search bar$")
	public void search_in_search_bar() throws Throwable
	{
		BBCHomePage BBCHomePage = new BBCHomePage(driver);
		BBCHomePage.searchbar("Houghton Mifflin Harcourt");
	}

	@And("^Verify search results$")
	public void verify_search_results() throws Throwable
	{
		CommonMethods commonpage=new CommonMethods(driver);
		BBCSearchPage BBCSearchPage=new BBCSearchPage(driver);
		BBCSearchPage.AssertSearchResults("Vivendi buys US education publisher");
		commonpage.AssertCurrentURL("https://www.bbc.co.uk/search?q=Houghton+Mifflin+Harcourt");
	}

	@And("^Verify Day and Date is correctly displayed$")
	public void verify_day_date_displayed()
	{
		CommonMethods commonpage=new CommonMethods(driver);
		BBCHomePage BBCHomePage = new BBCHomePage(driver);
		String datecapturedfromsystem=commonpage.DateFromCurrentDate(0);
		String datecapturedfrompage=BBCHomePage.getdate();
		System.out.println("Date Captured from System: "+ datecapturedfromsystem);
		System.out.println("Date Captured from Webpage: "+ datecapturedfrompage);
		commonpage.AssertTwoTextComparison(datecapturedfromsystem, datecapturedfrompage);
	}

	@And("^Close the browser$")
	public void close_the_browser() throws InterruptedException
	{
		Thread.sleep(7000L);
		System.out.println("*******CLOSING THE BROWSER*******");
		driver.close();
	}

}
