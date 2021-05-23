/**
 * 
 */
package PageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author yatinko
 *
 */
public class Homepage_PF {
	
	WebDriver driver;
	
	// WebElement components
	@FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/ul/li[1]/span")
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
	WebElement searchResultElement;
	
	@FindBy(xpath = "//*[@id=\"x-refine__group__0\"]/ul/li/ul/li[1]/span")
	WebElement searchResultCategory;
	
	@FindBy(xpath = "//*[@id=\"s0-14-11-6-3-save_search1-answer-17\"]/div[1]/h3")
	WebElement searchResultDiv;
	
	// Constructor for PageFactory
	public Homepage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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

	public int checkTotalProducts() {
		String totalResultsString = totalResults.getText().replace(",", "");
		return Integer.parseInt(totalResultsString);
	}

	public String checkIfProductIsCorrect() {
		return searchResultElement.getText();
	}
	
	public String checkIfProductCategoryIsCorrect() {
		return searchResultCategory.getText();
	}

	public String checkNoProductFoundWarning() {
		return searchResultDiv.getText();
	}
}
