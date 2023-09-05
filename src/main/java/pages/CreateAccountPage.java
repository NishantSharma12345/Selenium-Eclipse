package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage 
{
	WebDriver driver;

	@FindBy(css = "#field-id_gender-1")
	private WebElement socialTitleRadioBtn;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstnameTextArea;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastnameTextArea;
	
	@FindBy(css = "#field-email")
	private WebElement emailTextArea;
	
	@FindBy(css = "#field-password")
	private WebElement passwordTextArea;
	
	@FindBy(xpath = "//button[@data-action='show-password']")
	private WebElement showPasswordBtn;
	
	@FindBy(css = "#field-birthday")
	private WebElement birthdateTextArea;
	
	@FindBy(xpath = "//input[@name='optin']")
	private WebElement receiveOffersCheckbox;
	  
	@FindBy(xpath = "//input[@name='customer_privacy']")
	private WebElement customerDataCheckbox;
	
	@FindBy(xpath = "//input[@name='newsletter']")
	private WebElement newsletterCheckbox;
	
	@FindBy(xpath = "//input[@name='psgdpr']")
	private WebElement termsAndConditionsCheckbox;
	
	@FindBy(css = ".form-control-submit")
	private WebElement saveBtn;
	
	public CreateAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement selectSocialTitle()
	{
		return socialTitleRadioBtn;
	}
	
	public WebElement enterFirstName()
	{
		return firstnameTextArea;
	}
	
	public WebElement enterLastName()
	{
		return lastnameTextArea;
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
	
	public WebElement enterBirthday()
	{
		return birthdateTextArea;
	}
	
	public WebElement selectReceiveOffersCheckbox()
	{
		return receiveOffersCheckbox;
	}
	
	public WebElement selectCustomerDataCheckbox()
	{
		return customerDataCheckbox;
	}
	
	public WebElement selectNewsletterCheckbox()
	{
		return newsletterCheckbox;
	}
	
	public WebElement selectTermsAndConditionsCheckbox()
	{
		return termsAndConditionsCheckbox;
	}
	
	public WebElement saveBtnVerify()
	{
		return saveBtn;
	}
}
