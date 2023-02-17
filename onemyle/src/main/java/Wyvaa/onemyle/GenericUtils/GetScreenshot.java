package Wyvaa.onemyle.GenericUtils;

import java.io.File;
import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetScreenshot {
	
	public static String getWebImage(WebDriver driver,String testCaseName)
	{
		//Take the Screenshot of WebPage
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		String filepath = "./errorshot/"+timeStamp+testCaseName+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(filepath);
		sourceFile.renameTo(destinationFile);
		return filepath;
	}
	
	public static String getElementImage(WebElement ele, WebDriver driver,String testCaseName)
	{
		//Take the Screenshot of WebElement
		File sourceFile = ele.getScreenshotAs(OutputType.FILE);
		String TimeStamp = LocalDateTime.now().toString().replace(":", "_");
		String filepath = "./errorshot/"+TimeStamp+testCaseName+".png";
		File destinationFile = new File(filepath);
		sourceFile.renameTo(destinationFile);
		return filepath;
	}
}
