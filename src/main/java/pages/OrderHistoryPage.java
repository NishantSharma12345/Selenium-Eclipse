package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage 
{
	WebDriver driver;
	
	@FindBy(css = ".order-actions a:nth-of-type(1)")
	private WebElement detailsBtn;
	
	@FindBy(xpath = "//a[text()='Reorder']")
	private WebElement reorderBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Back')]")
	private WebElement backToAccountBtn;
	
	@FindBy(xpath = "//footer[@class='page-footer']//a[2]/span")
	private WebElement HomeBtn;
	
	public OrderHistoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
