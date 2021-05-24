
package StepDefinitions;

import org.testng.Assert;

import PageFactory.Productpage_PF;
import TestPages.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author ankit
 *
 */
public class ProductpageSteps extends BaseClass{
	
	Productpage_PF productpage;

	@Before
	public void setup()
	{
		initialization();
		productpage = new Productpage_PF();
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	
	 @Given("^user is on home page$")
	 public void user_is_on_home_page() {
	     driver.get(prop.getProperty("homepageUrl"));    
	 }
	
	 @When("^user click on motors menu$")
	 public void user_click_on_motors_menu(){
	     productpage.clickOnMotors();
	 }
	
	 @Then("^search result page appears$")
	 public void search_result_page_appears() {
		 String title = productpage.validateProductPage();
	     Assert.assertEquals("Auto Parts Accessories in Parts & Accessories | eBay", title);
	 }
	
	@Given("user is on product page")
	public void user_is_on_product_page() {
	    driver.get("https://www.ebay.com/sch/6028/i.html?_from=R40&_nkw=Auto+Parts+Accessories&_blrs=recall_filtering");
	}
	@When("user click on shipping to section")
	public void user_click_on_shipping_to_section() {
		productpage.clickShippingLocation();
	}

	@Then("user choose {string} and enter valid {string}")
	public void user_choose_and_enter_valid(String country, String pin) {
		productpage.chooseCountry(country);
		productpage.enterPinCode(pin);
	}

	@Then("click on Go button")
	public void click_on_go_button() {
		productpage.clickGo();
	}
	@Then("shipping location is set")
	public void shipping_location_is_set() {
		productpage.verifySetLocation();
	}
}
