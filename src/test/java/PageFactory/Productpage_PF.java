
package PageFactory;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import TestPages.BaseClass;
import TestPages.ExcelReader;

/**
 * @author ankit
 *
 */
public class Productpage_PF extends BaseClass{

	public Productpage_PF()
	{
		PageFactory.initElements(driver,this);
	}
	
	//find Motors menu on Home page
	@FindBy(xpath="//*[@id=\"mainContent\"]/div[1]/ul/li[10]/a")
	WebElement motors_menu;
	
	//click on motors menu to visit Product page
	public void clickOnMotors()
	{
		motors_menu.click();
	}
	
	public String validateProductPage()
	{
		return driver.getTitle();
	}
	
	//Elements of Product page
	@FindBy(className="x-flyout__button")
	WebElement btnShipping;
	
	@FindBy(xpath="//*[@id=\"s0-14-11-5-1[0]-36\"]/form/div[1]/span/select")
	WebElement selectCountry;
	
	@FindBy(id="s0-14-11-5-1[0]-36-0-6-12-textbox")
	WebElement txtPincode;
	
	@FindBy(xpath="//*[@id=\"s0-14-11-5-1[0]-36\"]/form/input")
	WebElement btnGo;
	
	@FindBy(xpath="//*[@id=\"s0-14-11-5-1[0]-36-0\"]/button/span")
	WebElement location;
	
	@FindBy(xpath="//*[@id=\"s0-14-11-5-1[0]-36-invalid-zipcode\"]/span")
	WebElement errorMessage;
	
	public void clickShippingLocation() throws Exception
	{
		btnShipping.click();
		Thread.sleep(1000);
	}
	
	public void setLocation(String country, String pincode) throws Exception 
	{
		Select countrylist = new Select(selectCountry);
		countrylist.selectByVisibleText(country);
		Thread.sleep(1000);
		if(txtPincode.isEnabled())
		{
			txtPincode.clear();
			txtPincode.sendKeys(pincode);
		}
		Thread.sleep(2000);
	}
	
	public void clickGo() throws Exception
	{
		btnGo.click();
		Thread.sleep(1000);
	}
	
	public void verifySetLocation()
	{
		String loc1=txtPincode.getAttribute("Value");
		String loc2=location.getText();
		Assert.assertEquals(loc1, loc2);
	}
	
	public String displayErrorMessage()
	{
		return errorMessage.getText();
	}
	
//	public void setLocationFromExcel() throws Exception
//	{
//		String sheetName = prop.getProperty("valid_productpage_excelsheet_name");
//		int rowcount =Integer.parseInt(prop.getProperty("rowcount_valid"));
//		
//		int rowNum=0;
//		for(int i=0;i<rowcount;i++)
//		{
//			rowNum=i;
//		}
//		
//		ExcelReader reader = new ExcelReader();
//		List<Map<String,String>> testData = 
//				reader.getData(prop.getProperty("productpage_excelsheet_path"), sheetName);
//		String country = testData.get(rowNum).get("Country");
//		String pincode = testData.get(rowNum).get("Pincode");
//		
//		setLocation(country, pincode);
//	}
//	
	public void setLocationFromExcelInvalid() throws Exception
	{
		String country=null,pincode=null;
		String sheetName = prop.getProperty("invalid_productpage_excelsheet_name");
		int rowcount =Integer.parseInt(prop.getProperty("rowcount_invalid"));
		
		int rowNum=0;
		for(int i=0;i<rowcount;i++)
		{
			rowNum=i;
			
			ExcelReader reader = new ExcelReader();
			List<Map<String,String>> testData = 
					reader.getData(prop.getProperty("productpage_excelsheet_path"), sheetName);
			 country = testData.get(rowNum).get("Country");
			 pincode = testData.get(rowNum).get("Wrong_Pincode");
		}
		setLocation(country, pincode);
	}

}
