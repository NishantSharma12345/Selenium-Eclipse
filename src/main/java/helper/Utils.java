package helper;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils 
{
	public String getScreenshotPath(WebDriver driver, String testCaseName) throws IOException
	{
		File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDate = DateClass.dateFormat();
		String destination = System.getProperty("user.dir")+"//Screenshot//"+testCaseName+currentDate+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
	
	public void deleteScreenshot(/*String destination*/)
	{
		try 
		{
		    Files.deleteIfExists(Paths.get(System.getProperty("user.dir")+"//Screenshots//"+".png"));
		    //Files.deleteIfExists(Paths.get(destination));
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	
	public static void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToAppear(WebDriver driver,WebElement element, String attribute, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((element), attribute, value));				
	}
	
	public static void waitForElementToVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitUntilAlertIsPresent(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static Dimension getElementSize(WebElement element)
	{
		Dimension elementSize = ((RemoteWebElement)element).getSize();
		return elementSize;
	}
	
	public Dimension getWindowSize(WebDriver driver)
	{
		Dimension windowSize = driver.manage().window().getSize();
		return windowSize;
	}
	
	public static void sleep(int sec) 
	{
	    try
	    {
	    	Thread.sleep(sec*1000);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public static void setClipboardData(String string) 
	{
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	
	public static void uploadFile(String fileLocation) 
	{
		try 
		{
			// Setting ClipBoard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} 
		catch (Exception exp) 
		{
			exp.printStackTrace();
		}
	}
	
	public static String generateRandomEmail() 
	{
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(10000);  
		String email = "test"+ randomInt +"@test.com";
		return email;
	}

}
