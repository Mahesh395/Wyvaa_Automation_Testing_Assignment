package Wyvaa.onemyle.GenericUtils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtilities {

	WebDriver driver;
	JavascriptExecutor js;
	Actions action;

	public WebActionUtilities(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	// method can be used to send the text to element using WebElements method
	public void enterData(WebElement targetElement, String KeysToEnter) {
		clearText(targetElement);
		targetElement.sendKeys(KeysToEnter);
	}

	// method can be used to click on the element using WebElements method
	public void clickOnElement(WebElement targetElement) {
		targetElement.click();
	}

	// method can be used to clear the text of text box using WebElements method
	public void clearText(WebElement targetElement) {
		targetElement.clear();
	}

	// method can be used to get the text of element using WebElements method
	public void getElementText(WebElement targetElement) {
		targetElement.getText();
	}

	// method can be used to click on element using JavascriptExecutor
	public void jsclick(WebElement targetElement) {
		js.executeAsyncScript("arguments[0].click()", targetElement);
	}

	// method can be used to enter data using JavascriptExecutor
	public void enterJsData(WebElement targetElement, String KeysToEnter) {
		js.executeAsyncScript("arguments[0].value='" + KeysToEnter + "'", targetElement);
	}

	// method can be used for SCROLLING DOWN using JavascriptExecutor
	public void scrollDownUsingJS() {
		js.executeScript("window.scrollBy(0,500)", "");
	}

	// method can be used for SCROLLING DOWN using JavascriptExecutor
	public void scrollDownToElementUsingJS(WebElement targetElement) {
		js.executeScript("arguments[0].scrollIntoView(true)", targetElement);
	}

	// method can be used for SCROLLING DOWN using JavascriptExecutor
	public void scrollUpElmentUsingJS(WebElement targetElement) {
		js.executeScript("window.scrollBy(0,-500)", targetElement);
	}

	// method can be used for SCROLLING UP using JavascriptExecutor
	public void scrollUpUsingJS() {
		js.executeScript("window.scrollBy(0,-500)", "");
	}

	public void mouseHovering(WebElement targetElement) {
		action.moveToElement(targetElement).perform();
	}

	// method can be used to scroll down using Actions class method
	public void scrollDownUsingAction() {
		action.sendKeys(Keys.PAGE_DOWN).perform();
	}

	// method can be used to scroll up using Actions class method
	public void scrollUPUsingAction() {
		action.sendKeys(Keys.PAGE_UP).perform();
	}

	/*
	 * method can be used to upload the file using Actions class method
	 */
	public void uploadFileUsingAction(WebElement targetElement, String path) {
		action.sendKeys(targetElement, path).perform();
	}

	/*
	 * method can be used to upload the file using autoIT
	 */
	public void uploadFileUsingAUtoIT(WebElement targetElement, String autoIt_File_Path) {
		action.click(targetElement).perform();
		try {
			Runtime.getRuntime().exec(autoIt_File_Path);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	/*
	 * method can be used to upload the file using RobotClass
	 */
	public void uploadFileUsingRobotClass(WebElement targetElement, String file_Path) {

		action.click(targetElement).perform();
		try {
			Robot rb = new Robot();
			StringSelection str = new StringSelection(file_Path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			e.getMessage();
		}

	}

	// method can be used to right click on element
	public void rightClick(WebElement targetElement) {
		action.contextClick(targetElement).perform();
	}

	// method can be used to double click on element
	public void doubleClick(WebElement targetElement) {
		action.doubleClick(targetElement).perform();
	}

	// method can be used to drag and drop element
	public void dragAndDrop(WebElement source, WebElement destination) {
		action.dragAndDrop(source, destination).perform();
	}

	// method can be used for explicitWait for visibilityOf Element
	public void explicitWait(WebElement targetElement) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(targetElement));
		targetElement.click();
	}

	// method can be used to Switch driver controller to frame using index
	public void swtichToFrame(int index) {
		driver.switchTo().frame(index);
	}

	// method can be used to Switch driver controller to frame using Id/Name
	public void swtichToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	// method can be used to Switch driver controller to frame using WebElement
	public void swtichToFrame(WebElement targetElement) {
		driver.switchTo().frame(targetElement);
	}

	// method can be used to get the list of all the elements present in list box
	public List<WebElement> getDropDownElement(WebElement dropDown) {
		Select select = new Select(dropDown);
		return select.getOptions();
	}

	// method can be used to select the Element from the list box using Value
	public void selectUsingValue(WebElement dropDown, String valueText) {
		Select select = new Select(dropDown);
		select.selectByValue(valueText);
	}

	// method can be used to select the Element from the list box using visibleText
	public void selectUsingVisibleText(WebElement dropDown, String visibleText) {
		Select select = new Select(dropDown);
		select.selectByVisibleText(visibleText);
	}

	// method can be used to select the Element from the list box using Index
	public void selectUsingIndex(WebElement dropDown, int index) {
		Select select = new Select(dropDown);
		select.selectByIndex(index);
	}

}
