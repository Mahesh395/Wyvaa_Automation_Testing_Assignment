package Wyvaa.onemyle.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wyvaa.onemyle.GenericUtils.WebActionUtilities;

public class CompanyPage {
	
	WebDriver driver;
	public CompanyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="xpath for Create_page_button")
	private WebElement Create_page_button ;
	
	public WebElement getCreate_page_button() {
		return Create_page_button;
	}

	public void setCreate_page_button(WebElement create_page_button) {
		Create_page_button = create_page_button;
	}
	
	public void clickOnCreatePageButton() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clickOnElement(Create_page_button);
	}	
	
}
