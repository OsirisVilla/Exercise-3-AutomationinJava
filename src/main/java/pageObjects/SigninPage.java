package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.Data;

public class SigninPage {
	
	WebDriver driver;
	WebDriverWait wait;
	Data data;

	@FindBy(id = "ap_email")
	WebElement txtEmail;

	@FindBy(id = "ap_password")
	WebElement txtPassword;

	@FindBy(id = "signInSubmit")
	WebElement btnSignInSubmit;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		data = new Data();
	}

	public void setEmail(String strEmail) {
		try {
			wait.until(ExpectedConditions.visibilityOf(txtEmail));
			strEmail = data.getEmail();
			txtEmail.sendKeys(strEmail);
		} catch (Exception e) {
			System.err.println("Scenario failed " + e.getMessage());
			driver.quit();
		}
	}
	
	public void setPassword(String strPassword) {
		try {
			wait.until(ExpectedConditions.visibilityOf(txtPassword));
			strPassword = data.getPassword();
			txtPassword.sendKeys(strPassword);
		} catch (Exception e) {
			System.err.println("Scenario failed " + e.getMessage());
			driver.quit();
		}
	}
	
	public void clickBtnSignInSubmit() {
		try {
			wait.until(ExpectedConditions.visibilityOf(btnSignInSubmit));
			btnSignInSubmit.click();
		}catch(Exception e) {
			System.err.println("Scenario failed " + e.getMessage());
			driver.quit();
		}
	}
	
	public void performLogin(String strEmail, String strPassword) {
		this.setEmail(strEmail);
		this.setPassword(strPassword);
		this.clickBtnSignInSubmit();
	}

}
