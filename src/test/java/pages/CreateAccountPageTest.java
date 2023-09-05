package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import helper.Utils;

public class CreateAccountPageTest extends BaseClass
{
	HomePage hp;
	LoginPage lp;
	CreateAccountPage cap;
	
	@BeforeClass
	public void init()
	{
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		cap = new CreateAccountPage(driver);
	}
	
	@Test
	public void createAccountPerform()
	{
		hp.signInBtnClick().click();
		lp.createAccountLinkClick().click();
		cap.selectSocialTitle().click();
		cap.enterFirstName().sendKeys(prop.getProperty("firstname"));
		cap.enterLastName().sendKeys(prop.getProperty("lastname"));
		String email = Utils.generateRandomEmail();
		cap.enterEmailAddress().sendKeys(email);
		cap.enterPassword().sendKeys(prop.getProperty("password"));
		cap.enterBirthday().sendKeys(prop.getProperty("birthday"));
		cap.selectReceiveOffersCheckbox().click();
		cap.selectCustomerDataCheckbox().click();
		cap.selectNewsletterCheckbox().click();
		cap.selectTermsAndConditionsCheckbox().click();
		cap.saveBtnVerify().click();
	}
}
