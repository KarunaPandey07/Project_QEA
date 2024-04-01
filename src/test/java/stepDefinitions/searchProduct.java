package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class searchProduct {
WebDriver driver;

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karuna Pandey\\Downloads\\chromedriver-win64.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
	}

	@When("User searched with shortname {string} and extracted actual name of the product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) {
	    driver.findElement(By.cssSelector(".search-keyword")).sendKeys(shortName);
	    String Home_Product=driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	    System.out.println(Home_Product+" is the extracted Product Name from Home Page");
	}

	@Then("User searched with same shortname in offers page to check if product exist")
	public void user_searched_with_same_shortname_in_offers_page_to_check_if_product_exist() throws InterruptedException {
	    driver.findElement(By.cssSelector("div.cart>a:nth-of-type(2)")).click();
	    String childWindow=driver.getWindowHandle();
	    driver.switchTo().window(childWindow);
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#search-field")).sendKeys("Tom");
	    String offer_Product=driver.findElement(By.cssSelector(" table.table > tbody > tr > td:nth-child(1)")).getText();
	    System.out.println(offer_Product+" is the extracted Product Name from offer Page");
	    
	}
}
