package Wyvaa.onemyle.TestCases;

import org.testng.annotations.Test;

import Wyvaa.onemyle.GenericUtils.BaseTest;
import Wyvaa.onemyle.POM.CompanyPage;
import Wyvaa.onemyle.POM.CreatePage;

public class onemyle_TC07_Test extends BaseTest {
	
	@Test
	public void testcase7() {
		CompanyPage cp = new CompanyPage(driver);
		cp.clickOnCreatePageButton();
		CreatePage crtPg = new CreatePage(driver);
		crtPg.uploadIntroVideo();
	}
}
