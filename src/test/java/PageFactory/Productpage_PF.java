
package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestPages.BaseClass;

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
	
	public void clickShippingLocation()
	{
		btnShipping.click();
	}
	
	public void chooseCountry(String country)
	{
		Select countrylist = new Select(selectCountry);
		countrylist.selectByVisibleText(country);
	}
	
	public void enterPinCode(String pincode)
	{
		if(txtPincode.isEnabled())
		{
			txtPincode.clear();
			txtPincode.sendKeys(pincode);
		}
	}
	
	public void clickGo()
	{
		btnGo.click();
	}
	
	public boolean verifySetLocation()
	{
		String loc1=txtPincode.getAttribute("Value");
		String loc2=location.getText();
		if(loc1.equals(loc2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
