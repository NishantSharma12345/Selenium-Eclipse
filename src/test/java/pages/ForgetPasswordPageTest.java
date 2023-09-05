package pages;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class ForgetPasswordPageTest extends BaseClass
{
	HomePage hp;
	LoginPage lp;
	ForgetPasswordPage fpp;
	
	@BeforeClass
    public void init()
    {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		fpp = new ForgetPasswordPage(driver);
    }
	
	@Test(priority = 0)
	public void forgetPasswordPerformWithEmptyEmail() 
	{
		hp.signInBtnClick().click();
		lp.forgetPasswordLinkClick().click();
		fpp.sendResetLinkBtn().click();
		/*Utils.waitUntilAlertIsPresent(driver);
		String text = driver.switchTo().alert().getText();
		System.out.println(text);*/
	}
	
	@Test(priority = 1)
	public void forgetPasswordPerform() 
	{
		fpp.enterEmailAddress().sendKeys(prop.getProperty("email"));
		fpp.sendResetLinkBtn().click();
		Assert.assertEquals(fpp.succeessMessageVerify().getText(), 
				"If this email address has been registered in our shop, you will receive a link to reset your password at test@test.com.");
	}
}
