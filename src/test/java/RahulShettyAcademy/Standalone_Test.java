package RahulShettyAcademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;
import RahulShettyAcademy.PageObjects.LandingPage;
import RahulShettyAcademy.PageObjects.MyCart;
import RahulShettyAcademy.PageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone_Test {
	
	
	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		
		
		String productName1="ZARA COAT 3";
		String productName2="IPHONE 13 PRO";
		 WebDriver driver = new ChromeDriver();
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karuna Pandey\\Downloads\\chromedriver_win32.exe");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		LandingPage landingpage= new LandingPage(driver);
		landingpage.goTo();
		landingpage.ApplicationLogin("karunapandey2000@gmail.com", "Karuna@07");
		
		
		ProductCatalogue prodcat=new ProductCatalogue(driver);
		List<WebElement>Products=prodcat.getProdList();
		prodcat.AddToCart1(productName1);
		
		List<WebElement>Products2=prodcat.getProdList();
		prodcat.AddToCart2(productName2);
		
		prodcat.ClickCart();
		
		/*WebElement Prod2=Products.stream().filter(product2 -> 
		product2.findElement(By.cssSelector("b")).getText().equals(productName2)).findFirst().orElse(null);
		Prod2.findElement(By.cssSelector("div.card-body>button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));*/
		
		
		MyCart cart=new MyCart(driver);
		Boolean cart1=cart.MatchCartProduct(productName1);
		
		/*List<WebElement> cartprod = driver.findElements(By.cssSelector(".cartSection>h3"));

		boolean cart1 =cartprod.stream().anyMatch(cartProduct1 -> 
		cartProduct1.getText().equalsIgnoreCase(productName1));*/

		Assert.assertTrue(cart1);
		
		Boolean cart2=cart.MatchCartProduct(productName2);
		
		/*boolean cart2=cartprod.stream().anyMatch(cartProduct2-> 
		cartProduct2.getText().equalsIgnoreCase(productName2));*/
		
		Assert.assertTrue(cart2);
		
		AbstractComponents AbsComp= new AbstractComponents(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", driver.findElement(By.xpath("/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")));
		 
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("div>div.details__user>div.user__name>div.user__address>div.form-group>input.input")), "india").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.ta-results")));
		driver.findElement(By.cssSelector("section.ta-results>button:nth-of-type(2)")).click();
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", driver.findElement(By.cssSelector("body > app-root > app-order > section > div > div > div.col-md-7 > div > div > div.payment__info > div.payment__shipping > div.details__user > div > div.actions > a")));
		 
		String confirmMsg= driver.findElement(By.cssSelector("h1.hero-primary")).getText();
		
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		driver.quit();		
		

		
}
}

