/**
 * 
 */
package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageFactory.Homepage_PF;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author yatinko
 *
 */
public class HomepageSteps {
	WebDriver driver;
	Homepage_PF home;
	
	@Before
	public void config() {
//		Initializing web driver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@After
	public void wrapUp() {
		driver.close();
	}
	
	@Given("User is already on HomePage")
	public void user_is_already_on_home_page() {		
//	    Navigating to the homepage
		driver.get("https://www.ebay.com/");
		System.out.println("========================================");
	}

	@Given("User is on HomePage")
	public void user_is_on_home_page() {
//		Initializing home object
		home = new Homepage_PF(driver);
		
//		Getting navbar home component's text
		String navHomeSpanString = home.getHomeNavText();
		System.out.println(navHomeSpanString);
	    
//	   	Check if the home component is active
	   	Assert.assertEquals(navHomeSpanString, "Home");
	   	System.out.println("User is on homepage");
	}

	@Then("check the title of the page")
	public void check_the_title_of_the_page() {
//		Getting the page title
		String title = driver.getTitle();
		
//		Checking if the title is correct
	    Assert.assertEquals("Electronics, Cars, Fashion, Collectibles & More | eBay", title);
	    System.out.println("Title matched");
	}

	@When("When user enters <validSearchItem> & <validSearchCategory> in searchbar")
	public void user_enters_valid_data_in_searchbar(String validSearchItem, String validSearchCategory) {
	    
		home.enterSearchText(validSearchItem);
		home.selectSearchCategory(validSearchCategory);
	}

	@And("clicks the Search button")
	public void clicks_the_search_button() {
		home.searchProduct();
	}

	@Then("display relevant products")
	public void display_relevant_products() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user invalid data in searchbar")
	public void user_invalid_data_in_searchbar() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("display appropriate message")
	public void display_appropriate_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user hovers cursor on navbar elements")
	public void user_hovers_cursor_on_navbar_elements() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("display navbar components")
	public void display_navbar_components() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on a navbar component")
	public void user_clicks_on_a_navbar_component() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("navigate to the appropriate page")
	public void navigate_to_the_appropriate_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on a footer link")
	public void user_clicks_on_a_footer_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
