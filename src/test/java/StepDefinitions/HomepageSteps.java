/**
 * 
 */
package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author yatink
 *
 */
public class HomepageSteps {
	WebDriver driver;
	@Given("User is already on HomePage")
	public void user_is_already_on_home_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//	    Navigating to the homepage
	    driver.get("https://www.ebay.com/");
	}

	@Given("User is on HomePage")
	public void user_is_on_home_page() {
//		Finding navbar home component
		WebElement navHomeComponent = driver.findElement(By.className("hl-cat-nav__active"));
	   	WebElement navHomeSpan = navHomeComponent.findElement(By.tagName("span"));
	   	String navHomeSpanString = navHomeSpan.getText();
	    
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
	}
	
	@Then("User quits browser")
	public void user_quits_browser() {
	    driver.quit();
	}

	@When("user enters valid data in searchbar")
	public void user_enters_valid_data_in_searchbar() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@And("clicks the Search button")
	public void clicks_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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
