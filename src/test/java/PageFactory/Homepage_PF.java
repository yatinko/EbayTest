/**
 * 
 */
package PageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author yatinko
 *
 */
public class Homepage_PF {
	
	WebDriver driver;
	@FindBy(id = "hl-cat-nav__active")
	WebElement navHomeComponent;
	
	public Homepage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,Homepage_PF.class);
	}
}
