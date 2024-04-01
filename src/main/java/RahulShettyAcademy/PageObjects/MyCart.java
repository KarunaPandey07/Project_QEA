package RahulShettyAcademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class MyCart extends AbstractComponents{

	WebDriver driver;
	public MyCart(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection>h3")
	List<WebElement> cartsection;
	
	@FindBy(xpath="/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")
	WebElement checkoutbtn;
	
	public List<WebElement> CartProducts() {
		
		return cartsection;
	 
	}
	
	public boolean MatchCartProduct(String productName1) {
	
		boolean cart1 =CartProducts().stream().anyMatch(cartProduct1 -> cartProduct1.getText().equalsIgnoreCase(productName1));
		return cart1;
		
	}
	
	
	public boolean MatchCartProduct2(String productName2) {
		
		boolean cart2 =CartProducts().stream().anyMatch(cartProduct2 -> 
	    cartProduct2.getText().equalsIgnoreCase(productName2));
		return cart2;
		
	}
	
	public void ClickCheckout(WebElement btnlocator) {
		
		JavascriptExecuterClick(checkoutbtn);
	}

	
	
	
}
