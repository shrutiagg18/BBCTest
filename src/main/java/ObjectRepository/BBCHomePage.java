package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BBCHomePage 
{
	public WebDriver driver;
	
	public BBCHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Xpaths
	By popup=By.xpath("//p[text()='Consent']");
	By cookies=By.xpath("//*[@id='bbccookies-continue-button']");
	By newssection = By.xpath("(//a[text()='News'])[1]");
	By search= By.xpath("//input[@placeholder='Search']");
	By searchbutton = By.xpath("//button[@class='orb-search__button']");
	By date= By.xpath("//*[@id=\"page\"]/section[2]/h2");
	
	
	/**
	 * Description: Click Consent Popup on opening the BBC Website
	 */
	public void popupclick() throws Throwable
	{
		CommonMethods commonmethod = new CommonMethods(driver);
		commonmethod.click(popup);
				
	}
	
	/**
	 * Description: Click cookies popup
	 */
	public void cookiesclick() throws Throwable
	{
		CommonMethods commonmethod = new CommonMethods(driver);
		commonmethod.click(cookies);
	}
	
	/**
	 * Description: Click News section on top navigation bar
	 */
	public void newsclick() throws Throwable
	{
		CommonMethods commonmethod = new CommonMethods(driver);
		commonmethod.click(newssection);
	}
	
	/**
	 * Description: Enter text into search bar
	 */
	public void searchbar(String SearchString) throws Throwable
	{	CommonMethods commonmethod = new CommonMethods(driver);
		driver.findElement(search).sendKeys(SearchString);
		commonmethod.click(searchbutton);
	}
	
	/**
	 * Description: Capture Day and Date from BBC HomePage
	 */
	public String getdate()
	{
		Object Date = driver.findElement(date).getText();
		String DateFormatted = String.valueOf(Date).substring(19);
		return DateFormatted;
	}
	
}
