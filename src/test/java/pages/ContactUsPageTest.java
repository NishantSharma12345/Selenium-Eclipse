package pages;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import helper.Utils;

public class ContactUsPageTest extends BaseClass
{
	HomePage hp;
	ContactUsPage cup;
	
	@BeforeClass
	public void init()
	{
		hp = new HomePage(driver);
		cup = new ContactUsPage(driver);
	}
	
	@Test
	public void contactUsPageTestPerform()
	{
		hp.contactUsBtnClick().click();;
		Select selectSubjectOption = cup.selectSubjectOption();
		selectSubjectOption.selectByIndex(1);
		cup.enterEmailAddress().sendKeys(prop.getProperty("email"));;
		cup.chooseFileOption().click();
		Utils.uploadFile(prop.getProperty("chooseOptionFile"));
		cup.enterMessage().sendKeys("test");
		cup.sendBtnClick().click();
		Utils.waitForElementToVisible(driver, cup.successMessageVerify());
		Assert.assertEquals(cup.successMessageVerify().getText(), "Your message has been successfully sent to our team.");
	}
}
