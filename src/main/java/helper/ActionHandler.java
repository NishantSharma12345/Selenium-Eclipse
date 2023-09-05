package helper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

public class ActionHandler extends BaseClass
{
	public Actions builder = new Actions(driver);
	
    public void click(WebElement element)
    {
        builder.click(element).perform();
    }
    public void clickAndHold(WebElement element)
    {
        builder.clickAndHold(element).perform();
    }
    public  void doubleClick(WebElement element)
    {
        builder.doubleClick(element).perform();
    }
    public void dragAndDrop(WebElement source,WebElement target)
    {
        builder.dragAndDrop(source,target).perform();
    }
    public void dragAndDropBy(WebElement element,int xOffset,int yOffset)
    {
        builder.dragAndDropBy(element,xOffset,yOffset).perform();
    }
    public void moveToElement(WebElement element)
    {
        builder.moveToElement(element).perform();
    }
    public void rightClick(WebElement element)
    {
        builder.contextClick(element).perform();
    }
    public void keyDown(WebElement element,String value)
    {
        builder.keyDown(element,value);
    }
    public void keyUp(WebElement element,String value)
    {
        builder.keyUp(element,value);
    }
    public void moveByOffset(int xOffset,int yOffset)
    {
        builder.moveByOffset(xOffset, yOffset);
    }

    public void moveToElement(WebElement element,int xOffset,int yOffset)
    {
        builder.moveToElement(element,xOffset, yOffset);
    }
    public void sendKeys(WebElement element,String value)
    {
        builder.sendKeys(element,value).perform();
    }
    public void sendKeys(String value)
    {
        builder.sendKeys(value).perform();
    }

    /*public void scrollByAmount(int deltaX,int deltaY)
    {
        builder.scrollByAmount(deltaX,deltaY).perform();
    }*/

    /*public void scrollToElement(WebElement element)
    {
        builder.scrollToElement(element).perform();
    }*/
    
    public static void toOpenNewWindowTab(WebDriver driver, WebElement element)
    {
    	Actions builder = new Actions(driver);
        Actions seriesOfActions;
        seriesOfActions = builder
        		.keyDown(Keys.CONTROL)
        		.click(element)
        		.keyUp(Keys.CONTROL);   
        seriesOfActions.build().perform();
    }
    
    public static void toOpenNewWindow(WebDriver driver, WebElement element)
    {
    	Actions builder = new Actions(driver);
        Actions seriesOfActions;
        seriesOfActions = builder
        		.keyDown(Keys.SHIFT)
        		.click(element)
        		.keyUp(Keys.SHIFT);   
        seriesOfActions.build().perform();
    }
}
