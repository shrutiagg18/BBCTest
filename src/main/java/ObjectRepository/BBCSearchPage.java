package ObjectRepository;

import org.openqa.selenium.WebDriver;

public class BBCSearchPage 
{
	public WebDriver driver;
	
	public BBCSearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/**
	 * Description: Asserting search results by giving text input
	 */
	public void AssertSearchResults(String TextToCheck) throws Throwable
	{
		CommonMethods commonmethod = new CommonMethods(driver);
		commonmethod.AssertIfTextPresentOnPage(TextToCheck);
				
	}
	
	
}
