
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
	
//	 @Given("^user is on home page$")
//	 public void user_is_on_home_page() {
//	     driver.get(prop.getProperty("homepageUrl"));    
//	 }
//	
//	 @When("^user click on motors menu$")
//	 public void user_click_on_motors_menu(){
//	     productpage.clickOnMotors();
//	 }
//	
//	 @Then("^search result page appears$")
//	 public void search_result_page_appears() {
//		 String title = productpage.validateProductPage();
//	     Assert.assertEquals("Auto Parts Accessories in Parts & Accessories | eBay", title);
//	 }
//	
//	@Given("user is on product page")
//	public void user_is_on_product_page() {
//	    driver.get(prop.getProperty("productpageUrl"));
//	}
//	
//	@When("user click on shipping to section")
//	public void user_click_on_shipping_to_section() throws Exception {
//		productpage.clickShippingLocation();
//	}
//		
//	@Then("user choose {string} and enter valid {int}")
//	public void user_choose_and_enter_valid(String sheetName, Integer rowNum) throws Exception {
//	    
//		ExcelReader reader = new ExcelReader();
//		List<Map<String,String>> testData = 
//				reader.getData(prop.getProperty("productpage_excelsheet_path"), sheetName);
//		String country = testData.get(rowNum).get("Country");
//		String pincode = testData.get(rowNum).get("Pincode");
//		
//		productpage.setLocation(country, pincode);
//	}
//
//	@Then("click on Go button")
//	public void click_on_go_button() throws Exception {
//		productpage.clickGo();
//	}
//	
//	@Then("shipping location is set")
//	public void shipping_location_is_set() {
//
//	}
	
	@Given("User is on product page in motors category")
	public void user_is_on_product_page_in_motors_category() {
		driver.get(prop.getProperty("productpageUrl"));
	}
	
//	@When("user choose {string} and enter {int} of wrong pincode")
//	public void user_choose_and_enter_of_wrong_pincode(String sheetName, Integer rowNum) throws Exception {
//		productpage.clickShippingLocation();
//		
//		ExcelReader reader = new ExcelReader();
//		List<Map<String,String>> testData = 
//				reader.getData(prop.getProperty("productpage_excelsheet_path"), sheetName);
//		String country = testData.get(rowNum).get("Country");
//		String pincode = testData.get(rowNum).get("Wrong_Pincode");
//		
//		productpage.setLocation(country, pincode);
//	}
	
	@When("user select city and enter wrong pincode")
	public void user_select_city_and_enter_wrong_pincode() throws Exception {
		productpage.clickShippingLocation();
	    productpage.setLocationFromExcelInvalid();
	}
	
	@When("click Go button")
	public void click_go_button() throws Exception {
		productpage.clickGo();
	}
	@Then("display error message")
	public void display_error_message() {
	  String actualmsg =  productpage.displayErrorMessage(); 
	  String expectedmsg = "Please enter a valid zip code";
	  Assert.assertEquals(expectedmsg, actualmsg);
	}

}
