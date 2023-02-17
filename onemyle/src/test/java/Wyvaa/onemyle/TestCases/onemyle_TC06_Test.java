package Wyvaa.onemyle.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Wyvaa.onemyle.GenericUtils.BaseTest;
import Wyvaa.onemyle.GenericUtils.ExcelUtils;
import Wyvaa.onemyle.POM.CompanyPage;
import Wyvaa.onemyle.POM.CreatePage;

public class onemyle_TC06_Test extends BaseTest {
	
	@DataProvider(name = "pageURL")
	public Object[][] testData() throws Throwable
	{
		Object[][] data =  new Object[ExcelUtils.getRowCount(EXCEL_PATH, "Sheet1")][1];
		for (int i = 0; i < ExcelUtils.getRowCount(EXCEL_PATH, "Sheet1")-1 ; i++) {
			for (int j = 2; j < 3; j++)
			{
				data[i][j] = ExcelUtils.getStringValue(EXCEL_PATH, "Sheet1", i+1, j);
			}					
		}
		return data;
	}
	
	
	@Test(dataProvider = "pageURL")
	public void testcase6(String pageUrl) {
		CompanyPage cp = new CompanyPage(driver);
		cp.clickOnCreatePageButton();
		CreatePage crtPg = new CreatePage(driver);
		crtPg.enterPageURL(pageUrl);
	}

}
