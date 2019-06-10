package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {

	WebDriver driver;
	WebDriverWait wait;
	ResultsPage resultsPage;

	@FindBy(id = "price_inside_buybox")
	WebElement lblDetailPrice;

	@FindBy(id = "add-to-cart-button")
	WebElement btnAddToCart;

	// Initialize Elements
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		resultsPage = new ResultsPage(driver);
	}

	public String getDetailPrice() {
		return lblDetailPrice.getText();
	}

	public void clickBtnAddToCart() {
		try {
			wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
			btnAddToCart.click();
		} catch (Exception e) {
			System.err.println("Scenario failed " + e.getMessage());
			driver.quit();
		}
	}

}
