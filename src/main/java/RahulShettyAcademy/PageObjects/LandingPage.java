package RahulShettyAcademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) 
	{
		super(driver);
	this.driver=driver;	//initialization
	
	PageFactory.initElements(driver, this); //PageFactory
	}
	
	@FindBy(css="#userEmail")
	WebElement username;
	
	@FindBy(css="#userPassword")
	WebElement password;
	
	@FindBy(css="#login")
    WebElement loginbtn;
	
	public void ApplicationLogin(String Username,String Password) {
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginbtn.click();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client"); 
		
	}
	
	
}
