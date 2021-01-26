package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddressPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ShoppingPage;
import com.qa.utils.TestUtils;

public class ShoppingPageTest extends TestBase{
	

	ShoppingPage shoppingPage;
	AddressPage addressPage;
	LoginPage loginPage;
	TestUtils util;
	//HomePage homePage
	
	ShoppingPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		intialization();
		addressPage = new AddressPage();
		shoppingPage = new ShoppingPage();
		loginPage = new LoginPage();
		//loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = TestUtils.getTestData(prop.getProperty("SHEET_NAME"));
		return data;
	}
	
	@Test(priority=1)
	public void itemOneTest() {
		shoppingPage.goToShoppingPage();
		shoppingPage.selectItemOne();
		shoppingPage.addtoCart();
	}
	
	@Test(priority=2)
	public void itemTwoTest() {
		shoppingPage.goToShoppingPage();
		shoppingPage.selectItemTwo();
		shoppingPage.addtoCart();
	}
	
	@Test(priority=3)
	public void itemThreeTest() {
		shoppingPage.goToShoppingPage();
		shoppingPage.selectItemThree();
		shoppingPage.addtoCart();
	}
	
	@Test(priority=4)
	public void checkoutTest() {
		shoppingPage.checkOut();
	}
	
	@Test(priority=5)
	public void orderHistoryTest() {
		shoppingPage.orderHistory();
		util = new TestUtils();
		TestUtils.takeScreenshot();
	}
	
	@AfterClass
	public void tearDownn() {
		driver.quit();
	}


}
