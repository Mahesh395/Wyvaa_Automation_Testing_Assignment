package Wyvaa.onemyle.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Wyvaa.onemyle.GenericUtils.BaseTest;
import Wyvaa.onemyle.GenericUtils.ExcelUtils;
import Wyvaa.onemyle.POM.CompanyPage;
import Wyvaa.onemyle.POM.CreatePage;

public class onemyle_TC08_Test extends BaseTest {

	@DataProvider(name = "introduction")
	public Object[][] testData() throws Throwable
	{
		Object[][] data =  new Object[ExcelUtils.getRowCount(EXCEL_PATH, "Sheet1")][1];
		for (int i = 0; i < ExcelUtils.getRowCount(EXCEL_PATH, "Sheet1")-1 ; i++) {
			for (int j = 3; j < 4; j++)
			{
				data[i][j] = ExcelUtils.getStringValue(EXCEL_PATH, "Sheet1", i+1, j);
			}					
		}
		return data;
	}
	
	
	@Test(dataProvider = "introduction")
	public void testcase8(String introduction) {
	
		CompanyPage cp = new CompanyPage(driver);
		cp.clickOnCreatePageButton();
		CreatePage crtPg = new CreatePage(driver);
		crtPg.enterPageIntroductionPost(introduction);
	}
}
