package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class AddressPage extends TestBase{
	
	//Page Factory or OR
		@FindBy(xpath="//a[@title='Addresses']")
		WebElement addressButton;
		
		@FindBy(xpath="//a[@title='Add an address']")
		WebElement addAddress;
		
		@FindBy(id="firstname")
		WebElement firstName;
		
		@FindBy(id="lastname")
		WebElement lastName;
		
		@FindBy(id="company")
		WebElement company;
		
		@FindBy(id="address1")
		WebElement address1;
		
		@FindBy(id="address2")
		WebElement address2;
		
		@FindBy(id="city")
		WebElement city;
		
		@FindBy(id="id_state")
		WebElement id_state;
		
		@FindBy(id="postcode")
		WebElement postCode;
		
		@FindBy(id="id_country")
		WebElement id_country;
		
		@FindBy(id="phone")
		WebElement phone;
		
		@FindBy(id="phone_mobile")
		WebElement phone_mobile;
		
		@FindBy(id="other")
		WebElement other;
		
		@FindBy(id="alias")
		WebElement alias;
		
		@FindBy(id="submitAddress")
		WebElement addressSubmit;
		
		public AddressPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void addNewAddress(String fname, String lname, String company, String add1, String add2, String city, String state, String pcode, String country, String hPhone, String mPhone, String other, String alias) {
			firstName.clear();
			firstName.sendKeys(fname);
			lastName.clear();
			lastName.sendKeys(lname);
			this.company.sendKeys("company");
			address1.sendKeys(add1);
			address2.sendKeys(add2);
			this.city.sendKeys(city);
			
			Select selects = new Select(id_country);
			//selects.deselectByVisibleText(country);
			
			Select selectc = new Select(id_state);
			selectc.selectByVisibleText(state);
			
			postCode.sendKeys(pcode);
			phone.sendKeys(hPhone);
			phone_mobile.sendKeys(mPhone);
			
			this.other.sendKeys(other);
			this.alias.clear();
			this.alias.sendKeys(alias);
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			addressSubmit.click();
			

		}
		
		public void goToAddressPage() {
			addressButton.click();
			addAddress.click();
		}
		
		
}
