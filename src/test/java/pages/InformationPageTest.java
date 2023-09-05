package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class InformationPageTest extends BaseClass
{
	HomePage hp;
	LoginPage lp;
	YourAccountPage yap;
	InformationPage aap;
	
	@BeforeClass
	public void init()
	{
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		yap = new YourAccountPage(driver);
		aap = new InformationPage();
	}
	
	@Test
	public void editInformationPerform()
	{
		hp.signInBtnClick().click();
		lp.enterEmailAddress().sendKeys(prop.getProperty("email"));;
		lp.enterPassword().sendKeys(prop.getProperty("password"));
	    lp.signInBtnClick().click();
	    yap.informationBtnClickVerify().click();
	}
	
}
