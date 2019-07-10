package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//img[@data-image-index='0']")
	WebElement imgFirstProduct;

	@FindBy(xpath = "//div[@data-index='0']//span[@data-a-size='l']//span[@class='a-price-whole']")
	WebElement lblFirstPrice;

	// Initialize Elements
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public String getFirstPrice() {
		return lblFirstPrice.getText();
	}
	
	public void clickImgFirstProduct() {
		try {
			wait.until(ExpectedConditions.visibilityOf(imgFirstProduct));
			imgFirstProduct.click();
		} catch (Exception e) {
			System.err.println("Scenario failed " + e.getMessage());
			driver.quit();
		}
	}

}
