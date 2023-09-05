package pages;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class AddAddressPageTest extends BaseClass
{
	HomePage hp;
	LoginPage lp;
	YourAccountPage yap;
	AddAddressPage aap;
	
	@BeforeClass
	public void init()
	{
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		yap = new YourAccountPage(driver);
		aap = new AddAddressPage(driver);
	}
	
	@Test
	public void addAddressPerform()
	{
		hp.signInBtnClick().click();
		lp.enterEmailAddress().sendKeys(prop.getProperty("email"));;
		lp.enterPassword().sendKeys(prop.getProperty("password"));
	    lp.signInBtnClick().click();
	    yap.addressesBtnClickVerify().click();
	    aap.enterAlias().sendKeys(prop.getProperty("alias"));
	    aap.enterFirstName().sendKeys(prop.getProperty("firstname"));
	    aap.enterLastName().sendKeys(prop.getProperty("lastname"));
	    aap.enterCompany().sendKeys(prop.getProperty("company"));
	    aap.enterVatNumber().sendKeys(prop.getProperty("vatNumber"));
	    aap.enterAddress().sendKeys(prop.getProperty("address"));
	    aap.enterAddressComplement().sendKeys(prop.getProperty("addressComplement"));
	    aap.enterCity().sendKeys(prop.getProperty("city"));
	    aap.enterZipPostalCode().sendKeys(prop.getProperty("zipCode"));
	    Select selectStateOption = aap.selectState();
	    selectStateOption.selectByValue(prop.getProperty("state"));
	    Select selectCountryOption = aap.selectCountry();
	    selectCountryOption.selectByValue(prop.getProperty("country"));
	    aap.enterPhone().sendKeys(prop.getProperty("phone"));
	    aap.saveBtnClickVerify().click();
	}
}
