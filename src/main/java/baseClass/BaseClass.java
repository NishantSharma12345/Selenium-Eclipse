package baseClass;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public WebDriver driver;
	public Properties prop;
	
	public BaseClass()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void configurBrowser()
	{
		String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browser.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			if(browser.contains("headless"))
			{
				options.addArguments("--headless", "--window-size=1920,1200");				
			}
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-extensions");
			//options.addExtensions(new File("/path/to/extension.crx"))
			
			//options.addArguments("start-maximized");
			//options.addArguments("--incognito");
			//To disable popup window
			options.setExperimentalOption("excludeSwitches",
				    Arrays.asList("disable-popup-blocking"));
			//options.setBinary("/path/to/other/chrome/binary");
			//options.setBinary(new File("/path/to/chrome"));
			
			//To disable the ribbon alert which comes on the chrome browser when the browser 
			//is invoked via Selenium use –
			options.addArguments("disable-infobars");
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", "/home/users");
			options.setExperimentalOption("prefs", prefs);
			
			driver = new ChromeDriver(options);
		}
		else if(browser.contains("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.contains("microsoftEdge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.contains("safari"))
		{
			driver = new SafariDriver();			
		}
		else if(browser.contains("internetExplorer"))
		{
			driver = new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass()
	public void tearDown()
	{
		driver.quit();
	}
}
