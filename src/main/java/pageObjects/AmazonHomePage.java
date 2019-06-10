package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.Data;

public class AmazonHomePage {

	WebDriver driver;
	WebDriverWait wait;
	Data data;

	@FindBy(id = "nav-link-yourAccount")
	WebElement lnkSignIn;

	@FindBy(id = "twotabsearchtextbox")
	WebElement txtSearchField;

	@FindBy(xpath = "//input[@type='submit' and @value='Ir']")
	WebElement btnSearchSubmit;

	@FindBy(xpath = "//a[@id='nav-link-yourAccount']//span[@class='nav-line-1']")
	WebElement lnkYourAccount;

	// Initialize Elements
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		data = new Data();
	}

	public void clickLnkSignIn() {
		try {
			wait.until(ExpectedConditions.visibilityOf(lnkSignIn));
			lnkSignIn.click();
		} catch (Exception e) {
			System.err.println("Scenario failed " + e.getMessage());
			driver.quit();
		}

	}

	public void searchProduct(String strProduct) {
		try {
			wait.until(ExpectedConditions.visibilityOf(txtSearchField));
			
			txtSearchField.clear();
			
			txtSearchField.sendKeys(strProduct);
			
			btnSearchSubmit.click();
			
		} catch (Exception e) {
			System.err.println("Scenario failed " + e.getMessage());
			driver.quit();
		}
	}

	public String getGreeting() {
		return lnkYourAccount.getText();
	}

}
