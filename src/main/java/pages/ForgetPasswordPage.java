package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage 
{
	WebDriver driver;
	
	@FindBy(css = "#email")
	private WebElement emailTextArea;
	
	@FindBy(css = "#send-reset-link")
	private WebElement sendResetLinkBtn;
	
	@FindBy(css = ".item p")
	private WebElement successMessageText;
	
	public ForgetPasswordPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement enterEmailAddress()
	{
		return emailTextArea;
	}
	
	public WebElement sendResetLinkBtn()
	{
		return sendResetLinkBtn;
	}
	
	public WebElement succeessMessageVerify()
	{
		return successMessageText;
	}
	
}
