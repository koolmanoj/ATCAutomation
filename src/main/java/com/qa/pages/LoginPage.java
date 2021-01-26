package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or OR
		
		@FindBy(xpath="//a[@class='login']")
		WebElement SignIn;
		
		@FindBy(id="email")
		@CacheLookup
		WebElement userName;
		
		@FindBy(id="passwd")
		@CacheLookup
		WebElement password;
		
		@FindBy(id="SubmitLogin")
		@CacheLookup
		WebElement loginBtn;
		
		@FindBy(xpath="//span[text()='Manoj Singh']")
		WebElement loginName;
		
	
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String validateUser() {
			return loginName.getText();	
		}
		
		public String validatePageTitle() {
			return driver.getTitle();
		}
		
		public AddressPage login(String un, String pwd) {
			SignIn.click();
			userName.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new AddressPage();
		}

}
