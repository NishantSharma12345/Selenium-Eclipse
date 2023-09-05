package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage 
{
	WebDriver driver;
	
	@FindBy(css = "a#identity-link > span")
	private WebElement informationBtn;
	
	@FindBy(css = "a#identity-link > span")
	private WebElement addressesBtn;
	
	@FindBy(css = "a#identity-link > span")
	private WebElement orderHistoryAndDetailsBtn;
	
	@FindBy(css = "a#identity-link > span")
	private WebElement creditSlipsBtn;
	
	@FindBy(css = "a#identity-link > span")
	private WebElement myWishlistsBtn;
	
	@FindBy(css = ".page-footer a")
	private WebElement signoutBtn;
	
	@FindBy(css = ".link-item")
	private List<WebElement> allOptionsBtn;
	
	public YourAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement informationBtnClickVerify()
	{
		return informationBtn;
	}
	
	public WebElement addressesBtnClickVerify()
	{
		return addressesBtn;
	}
	
	public WebElement orderHistoryAndDetailsBtnClickVerify()
	{
		return orderHistoryAndDetailsBtn;
	}
	
	public WebElement creditSlipsBtnClickVerify()
	{
		return creditSlipsBtn;
	}
	
	public WebElement myWishlistsBtnClickVerify()
	{
		return myWishlistsBtn;
	}
	
	public List<WebElement> allOptionsBtnClickVerify()
	{
		return allOptionsBtn;
	}
	
	public WebElement signoutBtnClickVerify()
	{
		return signoutBtn;
	}
}
