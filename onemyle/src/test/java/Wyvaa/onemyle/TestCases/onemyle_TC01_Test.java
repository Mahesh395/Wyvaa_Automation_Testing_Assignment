package Wyvaa.onemyle.TestCases;

import org.testng.annotations.Test;

import Wyvaa.onemyle.GenericUtils.BaseTest;
import Wyvaa.onemyle.POM.CompanyPage;

public class onemyle_TC01_Test extends BaseTest {
	
	@Test
	public void testCase1() {
		CompanyPage cp = new CompanyPage(driver);
		cp.clickOnCreatePageButton();
	}
}
