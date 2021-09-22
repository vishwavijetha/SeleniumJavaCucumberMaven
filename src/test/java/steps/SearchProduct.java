package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {

	protected WebDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@When("user navigates to amazon url")
	public void user_navigates_to_amazon_url() {
		driver.get("https://www.amazon.com/");
	}

	@Then("amaozon website should be displayed")
	public void amaozon_website_should_be_displayed() {
		Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
	}

	@Given("user enters {string} in searchbox")
	public void user_enters_in_searchbox(String string) {
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(string);
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() throws InterruptedException {
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
	}

	@Then("user verifies search result")
	public void user_verifies_search_result() {
		List<WebElement> searchResult = driver
				.findElements(By.xpath("//div[contains(@data-cel-widget,'search_result')]//h2"));
		searchResult.forEach(element -> System.out.println(element.getText()));
	}
}
