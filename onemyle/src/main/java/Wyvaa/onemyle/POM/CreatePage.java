package Wyvaa.onemyle.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wyvaa.onemyle.GenericUtils.WebActionUtilities;

public class CreatePage {
	
	WebDriver driver;
	
	public CreatePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="xpath for PageName text box")
	private WebElement PageName_textbox ;
	
	@FindBy(xpath="xpath for DescriptionText text box")
	private WebElement DescText_textbox;
	
	@FindBy(xpath="xpath for ProfilePicture_Browsefiles link")
	private WebElement ProfilePicture_Browsefiles_link;

	@FindBy(xpath="xpath for CoverPicture_Browsefiles link")
	private WebElement CoverPicture_Browsefiles_link;
	
	@FindBy(xpath="xpath for URL Text box")
	private WebElement URL_textbox;
	
	@FindBy(xpath="xpath for Intro_Video_Browsefiles link")
	private WebElement IntroVideo_Browsefiles_link;
	
	@FindBy(xpath="xpath for Intro_Post text box")
	private WebElement Intro_Post_textbox;
	
	@FindBy(xpath="xpath for Facebook text box")
	private WebElement FB_textbox;
	
	@FindBy(xpath="xpath for Instagram text box")
	private WebElement Insta_textbox;
	
	@FindBy(xpath="xpath for LinkedIn text box")
	private WebElement LinkedIn_textbox;
	
	@FindBy(xpath="xpath for Twitter text box")
	private WebElement Twitter_textbox;
	
	@FindBy(xpath="xpath for connectmore_button")
	private WebElement connectmore_button;
	
	@FindBy(xpath="xpath for Create_Page Button")
	private WebElement Create_Page_Button;
	
	@FindBy(xpath="xpath for Save_Draft Button")
	private WebElement Save_Draft_Button;
	
	@FindBy(xpath="xpath for PreView_Page Button")
	private WebElement PreView_Button;
	
	@FindBy(xpath="xpath for Cancel Button")
	private WebElement Cancel_Button;
	
	@FindBy(xpath="xpath for Go_Back_To_Page_List Button")
	private WebElement GoBack_Button;
	
	
	/*
	 * uploading file using AutoIT
	 */
	public void uploadProfilePicture() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.uploadFileUsingAUtoIT(ProfilePicture_Browsefiles_link, "./resources/fileupload.exe");		
	}
	
	/*
	 * Uploading file using sendkeys method
	 */
	public void uploadCoverPicture() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.uploadFileUsingAction(CoverPicture_Browsefiles_link, "C:\\Users\\Mahesh R\\Downloads\\pexels-eberhard-grossgasteiger-443446.jpg");
	}
	
	/*
	 * uploading a file using robot class
	 */
	public void uploadIntroVideo() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.uploadFileUsingRobotClass(IntroVideo_Browsefiles_link, "C:\\Users\\Mahesh R\\Downloads\\mixkit-going-down-a-curved-highway-through-a-mountain-range-41576-medium.mp4");
	}
	
	public void enterPageName(String pagename) {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clearText(PageName_textbox);
		wau.enterData(PageName_textbox, pagename);
	}
	
	public void enterPageDescription(String desc) {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clearText(DescText_textbox);
		wau.enterData(DescText_textbox, desc);
	}
	
	public void enterPageURL(String url) {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clearText(URL_textbox);
		wau.enterData(URL_textbox, url);
	}
	
	public void enterPageIntroductionPost(String introduction) {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.scrollDownUsingJS();
		wau.clearText(Intro_Post_textbox);
		wau.enterData(Intro_Post_textbox, introduction);
	}
	
	public void enterPageFacebookLink(String fblink) {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.scrollDownUsingJS();
		wau.clearText(FB_textbox);
		wau.enterData(FB_textbox, fblink);
	}
	
	public void enterPageInstagramLink(String instalink) {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.scrollDownUsingJS();
		wau.clearText(Insta_textbox);
		wau.enterData(Insta_textbox, instalink);	
	}
	
	public void enterPageLinkedInLink(String linkedInLink) {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.scrollDownUsingJS();
		wau.clearText(LinkedIn_textbox);
		wau.enterData(LinkedIn_textbox, linkedInLink);	
	}
	
	public void enterPageTwitterLink(String twitterLink) {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.scrollDownUsingJS();
		wau.clearText(Twitter_textbox);
		wau.enterData(Twitter_textbox, twitterLink);	
	}
	
	public void clickOnCreatePageButton() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clickOnElement(Create_Page_Button);
	}
	
	public void clickOnSaveDraftButton() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clickOnElement(Save_Draft_Button);
	}
	
	public void clickOnCancelButton() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clickOnElement(Cancel_Button);
	}
	
	public void clickOnBackToPageListButton() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clickOnElement(GoBack_Button);
	}
	
	public void clickOnPreViewPageButton() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clickOnElement(PreView_Button);
	}
	
	public void clickOnConnectMoreButton() {
		WebActionUtilities wau = new WebActionUtilities(driver);
		wau.clickOnElement(connectmore_button);
	}
	
	
	
}
