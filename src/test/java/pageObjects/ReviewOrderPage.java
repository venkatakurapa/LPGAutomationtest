package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReviewOrderPage {

	WebDriver driver;

	public ReviewOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".travel-date--datepicker")
	public WebElement date_picker;

	@FindBy(how = How.XPATH, using = "//a[text()='Continue to payment']")
	public WebElement continue_to_payment;

	public void verifyReviewOrderPage() {
		assertEquals(driver.getTitle(), "Review Your Order | Go Boston");
	}

	public void selectDate() throws InterruptedException {
		Thread.sleep(15000);
		date_picker.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[contains(text(),'23')]")).click();
	}

}
