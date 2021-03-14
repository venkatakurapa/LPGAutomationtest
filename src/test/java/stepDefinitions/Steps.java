package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.ExplorerPage;
import pageObjects.HomePage;
import pageObjects.PageObjectsManager;
import pageObjects.ReviewOrderPage;

public class Steps {

	WebDriver driver;
	HomePage homePage;
	PageObjectsManager pageObjectManager;
	ExplorerPage explorerPage;
	ReviewOrderPage reviewOrderPage;

	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pageObjectManager = new PageObjectsManager(driver);
		homePage = pageObjectManager.getHomePage();
		driver.get("https://gocity.com/boston/en-us/products/all-inclusive");
	}

	@Given("^I navigate to the explorer page$")
	public void i_navigate_to_the_explorer_page() throws Throwable {
		homePage.explorer_link.click();
	}

	@Given("^I select four choice pass$")
	public void i_select_four_choice_pass() throws Throwable {
		explorerPage = pageObjectManager.getExplorerPage();
		explorerPage.choosePass();
	}

	@When("^I click on checkout button$")
	public void i_click_on_checkout_button() throws Throwable {
		explorerPage.checkout.click();
	}

	@Then("^I should go to review your order page$")
	public void i_should_go_to_review_your_order_page() throws Throwable {
		reviewOrderPage = pageObjectManager.getReviewOrderPage();
		reviewOrderPage.verifyReviewOrderPage();
	}

	@Then("^I select visiting date$")
	public void i_select_visiting_date() throws Throwable {
		reviewOrderPage.selectDate();
	}

	@When("^I press continue to payment button$")
	public void i_press_continue_to_payment_button() throws Throwable {
		reviewOrderPage.continue_to_payment.click();
	}

	@Then("^I should see the payment page$")
	public void i_should_see_the_payment_page() throws Throwable {
		assertEquals(driver.getTitle(), "Payment | Go Boston");
	}

}
