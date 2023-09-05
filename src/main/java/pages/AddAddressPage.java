package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAddressPage 
{
	WebDriver driver;
	
	@FindBy(css = "#field-alias")
	private WebElement aliasTextArea;
	
	@FindBy(css = "#field-firstname")
	private WebElement firstNameTextArea;
	
	@FindBy(css = "#field-lastname")
	private WebElement lastNameTextArea;
	
	@FindBy(css = "#field-company")
	private WebElement companyTextArea;
	
	@FindBy(css = "#field-vat_number")
	private WebElement vatNumberTextArea;
	
	@FindBy(css = "#field-address1")
	private WebElement addressTextArea;
	
	@FindBy(css = "#field-address2")
	private WebElement addressComplementTextArea;
	
	@FindBy(css = "#field-city")
	private WebElement cityTextArea;
	
	@FindBy(css = "#field-postcode")
	private WebElement zipPostalCodeTextArea;
	
	@FindBy(css = "#field-id_state")
	private WebElement stateDropdown;
	
	@FindBy(css = "#field-id_country")
	private WebElement countryDropdown;
	
	@FindBy(css = "#field-phone")
	private WebElement phoneTextArea;
	
	@FindBy(css = "button.float-xs-right")
	private WebElement saveBtn;
	
	public AddAddressPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement enterAlias()
	{
		return aliasTextArea;
	}
	
	public WebElement enterFirstName()
	{
		return firstNameTextArea;
	}
	
	public WebElement enterLastName()
	{
		return lastNameTextArea;
	}
	
	public WebElement enterCompany()
	{
		return companyTextArea;
	}
	
	public WebElement enterVatNumber()
	{
		return vatNumberTextArea;
	}
	
	public WebElement enterAddress()
	{
		return addressTextArea;
	}
	
	public WebElement enterAddressComplement()
	{
		return addressComplementTextArea;
	}
	
	public WebElement enterCity()
	{
		return cityTextArea;
	}
	
	public WebElement enterZipPostalCode()
	{
		return zipPostalCodeTextArea;
	}
	
	public Select selectState()
	{
		Select stateDropdownOption = new Select(stateDropdown);
		return stateDropdownOption;
	}
	
	public Select selectCountry()
	{
		Select countryDropdownOption = new Select(countryDropdown);
		return countryDropdownOption;
	}
	
	public WebElement enterPhone()
	{
		return phoneTextArea;
	}
	
	public WebElement saveBtnClickVerify()
	{
		return saveBtn;
	}
}
