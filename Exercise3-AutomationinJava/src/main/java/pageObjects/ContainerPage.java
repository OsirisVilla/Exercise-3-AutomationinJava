package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContainerPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//span[@class='a-size-medium a-color-price hlb-price a-inline-block a-text-bold']")
	WebElement lblCartPrice;

	@FindBy(id = "nav-cart-count")
	WebElement lblCartCount;

	@FindBy(id = "a-autoid-0-announce")
	WebElement btnCarrito;

	@FindBy(xpath = "//input[@value='Eliminar']")
	WebElement btnEliminar;

	// Initialize Elements
	public ContainerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public String getCartPrice() {
		return lblCartPrice.getText();
	}

	public String getCartCount() {

		return lblCartCount.getText();
	}

	// Method to delete all items in the cart
	public void clickBtnCarrito() {
		try {
			wait.until(ExpectedConditions.visibilityOf(btnCarrito));
			btnCarrito.click();

			List<WebElement> btnEliminar = driver.findElements(By.xpath("//input[@value='Eliminar']"));
			for (WebElement ele : btnEliminar) {
				ele.click();
				Thread.sleep(750);
			}

		} catch (Exception e) {
			System.err.println("Scenario failed " + e.getMessage());
			driver.quit();
		}

	}

}
