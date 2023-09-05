package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy(css = "#field-email")
	private WebElement emailTextArea;
	
	@FindBy(css = "#field-password")
	private WebElement passwordTextArea;
	
	@FindBy(css = ".input-group-btn .btn")
	private WebElement showPasswordBtn;
	
	@FindBy(css = ".forgot-password a")
	private WebElement forgotYourPasswordLink;
	
	@FindBy(css = "#submit-login")
	private WebElement signInBtn;
	
	@FindBy(css = ".no-account a")
	private WebElement createAccountLink;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement enterEmailAddress()
	{
		return emailTextArea;
	}
	
	public WebElement enterPassword()
	{
		return passwordTextArea;
	}
	
	public WebElement passwordShowVerify()
	{
		return showPasswordBtn;
	}
	
	public WebElement forgetPasswordLinkClick()
	{
		return forgotYourPasswordLink;
	}
	
	public WebElement signInBtnClick()
	{
		return signInBtn;
	}
	public WebElement createAccountLinkClick()
	{
		return createAccountLink;
	}
	
}
