/**
 * 
 */
package PageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author yatinko
 *
 */
public class Homepage_PF {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*li[@id=\"hl-cat-nav__active\"]/span")
	WebElement navHomeComponent;
	
	@FindBy(xpath = "//*[@id=\"gh-ac\"]")
	WebElement searchBarText;
	
	@FindBy(xpath = "//*[@id=\"gh-cat\"]")
	WebElement searchBarCategory;
	
	@FindBy(xpath = "//*[@id=\"gh-btn\"]")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span[1]")
	WebElement totalResults;
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span[2]")
	WebElement searchElement;
	
	public Homepage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,Homepage_PF.class);
	}
	
	public String getHomeNavText() {
	   	return navHomeComponent.getText();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void quit() {
		driver.quit();
	}

	public void enterSearchText(String validSearchItem) {
		searchBarText.sendKeys(validSearchItem);
	}
	
	public void selectSearchCategory(String validSearchCategory) {
		Select searchDropDown = new Select(searchBarCategory);
		searchDropDown.selectByVisibleText(validSearchCategory);
	}

	public void searchProduct() {
		searchButton.click();
	}
}
