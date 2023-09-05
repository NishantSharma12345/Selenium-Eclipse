package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import helper.ActionHandler;

public class YourAccountPageTest extends BaseClass
{
	HomePage hp;
	LoginPage lp;
	YourAccountPage yap;
	
	@BeforeClass
	public void init()
	{
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		yap = new YourAccountPage(driver);
	}
	
	@Test
	public void allButtonsVerifyPerform()
	{
		hp.signInBtnClick().click();
		lp.enterEmailAddress().sendKeys(prop.getProperty("email"));
		lp.enterPassword().sendKeys(prop.getProperty("password"));
		lp.signInBtnClick().click();
		
		List<WebElement> allOptionsBtn = yap.allOptionsBtnClickVerify();
		
		for(int i = 0; i < allOptionsBtn.size(); i++)
		{
			ActionHandler.toOpenNewWindow(driver, allOptionsBtn.get(i));
			String originalWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) 
			{
			    if(!originalWindow.contentEquals(windowHandle)) 
			    {
			        driver.switchTo().window(windowHandle);
			        break;
			    }
			}
			driver.close();
			driver.switchTo().window(originalWindow);
		}
		
		yap.signoutBtnClickVerify().click();
	}
}
