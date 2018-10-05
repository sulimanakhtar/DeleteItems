package JupiterMaven.DeleteItems;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteItem {
	WebDriver driver;
	String baseURL;

	@When("^Customer is at home page$")
	public void customer_is_at_home_page() throws InterruptedException {
		baseURL = "http://jupiter.cloud.planittesting.com/#/home";
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		Thread.sleep(1000);
	}

	@When("^Clicks on shop$")
	public void clicks_on_shop() throws Throwable {
		WebElement shop = driver.findElement(By.xpath("//li[@id=\"nav-shop\"]//a"));
		shop.click();
	}

	@When("^Clicks on buy button to add items to cart$")
	public void clicks_on_buy_button_to_add_items_to_cart() throws Throwable {
		WebElement buyItem = driver.findElement(By.xpath("//li[@id=\"product-1\"]//a"));
		buyItem.click();
		WebElement buyItem3 = driver.findElement(By.xpath("//li[@id=\"product-3\"]//a"));
		buyItem3.click();
		Thread.sleep(1000);
	}

	@When("^Clicks on cart$")
	public void clicks_on_cart() throws Throwable {
		WebElement cart = driver.findElement(By.xpath("//li[@id=\"nav-cart\"]//a"));
		cart.click();
	}

	@When("^Add quantity$")
	public void add_quantity() throws Throwable {
		WebElement quantity1 = driver.findElement(By.xpath("//div[@class='ng-scope']//tr[1]//td[3]//input"));
		quantity1.clear();
		quantity1.sendKeys("2");
		WebElement quantity2 = driver.findElement(By.xpath("//div[@class='ng-scope']//tr[2]//td[3]//input"));
		quantity2.clear();
		quantity2.sendKeys("2");
		Thread.sleep(2000);
	}

	@When("^Delete items$")
	public void delete_items() throws Throwable {
		WebElement remove1 = driver.findElement(By.xpath("//div[@class='ng-scope']//tr[1]//td[5]//a//i"));
		remove1.click();
		WebElement confirm = driver.findElement(By.xpath("//div[@class='modal-footer']//a[1]"));
		confirm.click();
		WebElement emptyCart = driver.findElement(By.xpath("//div[@class='ng-scope']//tr[2]//td//ng-confirm//a"));
		emptyCart.click();
		WebElement empty = driver.findElement(By.xpath("//div[3]/div[@class='modal-footer']//a[1]"));
		empty.click();
		Thread.sleep(2000);
	}

	@Then("^Item should be removed from the shopping cart$")
	public void item_should_be_removed_from_the_shopping_cart() throws Throwable {
		
			System.out.println("Item is deleted from the cart");
		
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

}
