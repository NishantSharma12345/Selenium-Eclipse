package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage 
{
	WebDriver driver;
	
	@FindBy(css = "#id_contact")
	private WebElement subjectDropdown;
	
	@FindBy(css = "#email")
	private WebElement emailTextArea;
	
	@FindBy(css = ".buttonText")
	private WebElement chooseFileBtn;
	
	@FindBy(css = "#contactform-message")
	private WebElement messageArea;
	
	@FindBy(xpath = "//input[@value='Send']")
	private WebElement sendBtn;
	
	@FindBy(css = ".alert-success ul li")
	private WebElement successMessageText;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Select selectSubjectOption()
	{
		Select subjectDropdownOption = new Select(subjectDropdown);
		return subjectDropdownOption;
	}
	
	public WebElement enterEmailAddress()
	{
		return emailTextArea;
	}
	
	public WebElement chooseFileOption()
	{
		return chooseFileBtn;
	}
	
	public WebElement enterMessage()
	{
		return messageArea;
	}
	
	public WebElement sendBtnClick()
	{
		return sendBtn;
	}
	
	public WebElement successMessageVerify()
	{
		return successMessageText;
	}
}
