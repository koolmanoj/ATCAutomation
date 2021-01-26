package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddressPage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

public class AddressPageTest extends TestBase{
	
	AddressPage addressPage;
	LoginPage loginPage;
	//HomePage homePage
	
	AddressPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		addressPage = new AddressPage();
		addressPage.goToAddressPage();
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = TestUtils.getTestData(prop.getProperty("SHEET_NAME"));
		return data;
	}
	
	@Test(priority=1, dataProvider="getTestData")
	public void addNewAddressTest(String fname, String lname, String company, String add1, String add2, String city, String state, String pcode, String country, String hPhone, String mPhone, String other, String alias) {
		
		addressPage.addNewAddress(fname, lname, company, add1, add2, city, state, pcode, country, hPhone, mPhone, other, alias);
	}
	
	@AfterClass
	public void tearDownn() {
		driver.quit();
	}
	

}
