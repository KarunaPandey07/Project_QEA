package RahulShettyAcademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	
	public ProductCatalogue( WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement>Products= driver.findElements(By.cssSelector(".col-lg-4"));
	
	@FindBy(css=".col-lg-4")
	List<WebElement>Products;
	@FindBy(css="ul>li:nth-of-type(4)>button.btn.btn-custom")
	WebElement clickcart;
	By waitlocator=By.cssSelector(".col-lg-4");
	By cartEle=By.cssSelector("div.card-body>button:last-of-type");
	By toastContainer=By.cssSelector("#toast-container");
	By spinner=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProdList() {
		
		WaitForElementToAppear(waitlocator);
		return Products;
		
	}
	
	public  WebElement getProduct( String productName1) {
		
	WebElement Prod1= getProdList().stream().filter(product1 ->
	product1.findElement(By.cssSelector("b")).getText().equals(productName1)).findFirst().orElse(null);
	return Prod1;
	}
	
	public void AddToCart1(String productName1) {
		WebElement Prod1=getProduct(productName1);
		Prod1.findElement(cartEle).click();
		WaitForElementToAppear(toastContainer);
		WaitForElementToAppear(spinner);
	}
	
	public void AddToCart2(String productName2) {
		WebElement Prod2=getProduct(productName2);
		Prod2.findElement(cartEle).click();
		WaitForElementToAppear(toastContainer);
		WaitForElementToAppear(spinner);
	}
	
	public void ClickCart() {
		clickcart.click();
	}
	
	
	
} 
