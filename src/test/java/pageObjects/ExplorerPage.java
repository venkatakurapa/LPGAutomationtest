package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExplorerPage {

	WebDriver driver;

	public ExplorerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".form-control")
	public WebElement explorer_dropdown;

	@FindAll(@FindBy(how = How.CSS, using = ".lc-cart__item-amount-plus"))
	public List<WebElement> cart_item;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Checkout')]")
	public WebElement checkout;

	public void choosePass() throws InterruptedException {
		Thread.sleep(1500);
		Select pass = new Select(explorer_dropdown);
		pass.selectByIndex(2);
		Thread.sleep(1500);
		cart_item.get(0).click();
		Thread.sleep(1500);
		cart_item.get(1).click();
		Thread.sleep(1500);

	}
}
