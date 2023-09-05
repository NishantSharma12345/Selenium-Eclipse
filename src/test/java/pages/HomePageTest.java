package pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import helper.ActionHandler;
import helper.Utils;

public class HomePageTest extends BaseClass
{
	HomePage hp;
	
	@BeforeClass
	public void init()
	{
		hp = new HomePage(driver);
	}
	
	@Test
	public void homePageCMSLinksVerifyPerform()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int j = 0 ; j < 700 ; j++)
		{
			js.executeScript("window.scrollBy(0,"+j+")", ""); 			
			Utils.sleep(1);
			j=j+100;
		}
				
		List<WebElement> cmsPages = hp.cmsPageLinksList();
		
		for(int i = 0; i < cmsPages.size(); i++)
		{
			ActionHandler.toOpenNewWindowTab(driver,cmsPages.get(i));
			String originalWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) 
			{
			    if(!originalWindow.contentEquals(windowHandle)) 
			    {
			        driver.switchTo().window(windowHandle);
			        break;
			    }
			}
			Assert.assertEquals(cmsPages.get(i).getText(), driver.getTitle());
			driver.close();
			driver.switchTo().window(originalWindow);			
		}		
	}
	
}
