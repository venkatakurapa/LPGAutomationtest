package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {

	private WebDriver driver;
	private HomePage homePage;
	private ExplorerPage explorerPage;
	private ReviewOrderPage reviewOrderPage;

	public PageObjectsManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public ExplorerPage getExplorerPage() {
		return (explorerPage == null) ? explorerPage = new ExplorerPage(driver) : explorerPage;
	}

	public ReviewOrderPage getReviewOrderPage() {
		return (reviewOrderPage == null) ? reviewOrderPage = new ReviewOrderPage(driver) : reviewOrderPage;
	}
}
