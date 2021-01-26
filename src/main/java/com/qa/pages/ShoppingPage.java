package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ShoppingPage extends TestBase{
	
	JavascriptExecutor ex = (JavascriptExecutor)driver;
	
	//Page Factory or OR
	@FindBy(xpath="//a[@title='Women']")
	WebElement women;
	
	@FindBy(xpath="//li[@id='category-thumbnail']//preceding::a[@title='Summer Dresses']")
	WebElement summerDresses;
	
	@FindBy(xpath="//li[@id='grid' and @class='selected']")
	WebElement gridView;
	
	@FindBy(xpath="//i[@class='icon-th-list']")
	WebElement selectListView;
	
	@FindBy(xpath="//li[@id='list' and @class='selected']")
	WebElement listView;
	
	@FindBy(xpath="//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=5&token=13ce49ef5e7d2c61e0428e2409764f8e']//following::span[text()='More'][1]")
	WebElement item1;
	
	@FindBy(xpath="//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=6&token=13ce49ef5e7d2c61e0428e2409764f8e']//following::span[text()='More'][1]")
	WebElement item2;
	
	@FindBy(xpath="//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=6&token=13ce49ef5e7d2c61e0428e2409764f8e']//following::span[text()='More'][2]")
	WebElement item3;
	
	@FindBy(xpath="//i[@class='icon-plus']")
	WebElement plus;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement size;
	
	@FindBy(xpath="//a[@id='color_16']")
	WebElement colour;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	WebElement continueS;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement shoppingCart;
	
	@FindBy(xpath="//a[@title='Check out']")
	WebElement checkOut;
	
	@FindBy(xpath="//a[@href='http://automationpractice.com/index.php?controller=order&step=1']")
	WebElement processItem;
	
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement processaddress;
	
	@FindBy(xpath="//div[@id='uniform-cgv']")
	WebElement process2;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement processCarrier;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement payMethod;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement confirm;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement account;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderDetails;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement logOut;
	
	public ShoppingPage() {
		PageFactory.initElements(driver, this);	
	}

	public void goToShoppingPage() {
		Actions action = new Actions(driver);
		action.moveToElement(women).build().perform();
		
		summerDresses.click();
		selectListView.click();
	}
	
	public void selectItemOne() {
		//item1.click();
		item1.click();
	}
	
	public void selectItemTwo() {
		item2.click();
	}
	
	public void selectItemThree() {
		item3.click();
	}
	
	public void addtoCart() {
		for(int i=0; i<4; i++) {
			plus.click();
		}
		
		Select s = new Select(size);
		s.selectByVisibleText("L");
		
		colour.click();
		addToCart.click();
		continueS.click();
	}
	
	public void checkOut() {
		Actions action = new Actions(driver);
		action.moveToElement(shoppingCart).build().perform();
		
		checkOut.click();
		processItem.click();
		process2.click();
		processCarrier.click();
		payMethod.click();
		confirm.click();
		
	}
	
	public void orderHistory() {
		account.click();
		orderDetails.click();
		
	}
	
	public void LogOut() {
		logOut.click();
	}
	
	

}
