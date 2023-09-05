package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
	@FindBy(css = "#contact-link a")
	private WebElement contactUsBtn;
	
	@FindBy(css = "a .material-icons + .hidden-sm-down")
	private WebElement signInBtn;
	
	@FindBy(css = ".cms-page-link")
	private List<WebElement> cmsPageLinks;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement contactUsBtnClick()
	{
		return contactUsBtn;
	}
	
	public WebElement signInBtnClick()
	{
		return signInBtn;
	}
	
	public List<WebElement> cmsPageLinksList()
	{
		return cmsPageLinks;
	}
}
