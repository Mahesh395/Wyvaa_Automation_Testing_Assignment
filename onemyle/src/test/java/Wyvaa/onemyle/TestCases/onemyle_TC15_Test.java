package Wyvaa.onemyle.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Wyvaa.onemyle.GenericUtils.BaseTest;
import Wyvaa.onemyle.GenericUtils.ExcelUtils;
import Wyvaa.onemyle.POM.CompanyPage;
import Wyvaa.onemyle.POM.CreatePage;

public class onemyle_TC15_Test extends BaseTest {
	
	@DataProvider(name = "introduction")
	public Object[][] testData() throws Throwable
	{
		Object[][] data =  new Object[ExcelUtils.getRowCount(EXCEL_PATH, "Sheet1")][ExcelUtils.getColumnCount(EXCEL_PATH, "Sheet1")];
		for (int i = 0; i < ExcelUtils.getRowCount(EXCEL_PATH, "Sheet1")-1 ; i++) {
			for (int j = 0; j < ExcelUtils.getColumnCount(EXCEL_PATH, "Sheet1") ; j++)
			{
				data[i][j] = ExcelUtils.getStringValue(EXCEL_PATH, "Sheet1", i+1, j);
			}					
		}
		return data;
	}
	
	
	@Test(dataProvider = "CreatePageData")
	public void testcase15(String pageName, String description, String pageUrl, String introduction,String fbLink, String instaLink, String linkedInLink, String twitterLink) {
		
		CompanyPage cp = new CompanyPage(driver);
		cp.clickOnCreatePageButton();
		CreatePage crtPg = new CreatePage(driver);
		crtPg.enterPageName(pageName);
		crtPg.enterPageDescription(description);
		crtPg.uploadProfilePicture();
		crtPg.uploadCoverPicture();
		crtPg.enterPageURL(pageUrl);
		crtPg.uploadIntroVideo();
		crtPg.enterPageIntroductionPost(introduction);
		crtPg.enterPageFacebookLink(fbLink);
		crtPg.enterPageInstagramLink(instaLink);
		crtPg.enterPageLinkedInLink(linkedInLink);
		crtPg.enterPageTwitterLink(twitterLink);
		crtPg.clickOnPreViewPageButton();
		
	}

}
