package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class LoginPageTest extends BaseClass
{
	HomePage hp;
	LoginPage lp;
	
	@BeforeClass
	public void init()
	{
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
	}
	
	@Test
	public void accountLoginPerform()
	{
		hp.signInBtnClick().click();
		lp.enterEmailAddress().sendKeys(prop.getProperty("email"));;
		lp.enterPassword().sendKeys(prop.getProperty("password"));
	    lp.signInBtnClick().click();
	}
}
