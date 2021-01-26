package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddressPage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	AddressPage addressPage;
	
	public LoginPageTest() {
		super();
	}
  
  @BeforeClass
  public void setUp() {
	intialization();
	loginPage = new LoginPage();
	  }	
	
  @Test(priority=1)
  public void loginPageTitletest() {
	  String title = loginPage.validatePageTitle();
	  Assert.assertEquals(title, "My Store");
  }
  
  @Test(priority=2)
  public void loginTest() {
	  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  String user = loginPage.validateUser();
	  Assert.assertEquals(user, "Manoj Singh");
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }
 

}
