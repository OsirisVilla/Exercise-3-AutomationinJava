package stepDefs;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.Data;
import pageObjects.AmazonHomePage;
import pageObjects.ContainerPage;
import pageObjects.ProductDetailPage;
import pageObjects.ResultsPage;
import pageObjects.SigninPage;

public class StepDefs_Amazon {

	WebDriver driver;
	Data data;
	SigninPage signInPage;
	AmazonHomePage homePage;
	ResultsPage resultsPage;
	ProductDetailPage detailsPage;
	SoftAssert softAssertion;
	ContainerPage containerPage;
	String firstPrice;
	String firstProduct;
	String secondProduct;
	String strCartCount;

	public StepDefs_Amazon() {
		driver = ServiceHooks.driver;
		data = new Data();
		signInPage = new SigninPage(driver);
		homePage = new AmazonHomePage(driver);
		resultsPage = new ResultsPage(driver);
		detailsPage = new ProductDetailPage(driver);
		containerPage = new ContainerPage(driver);
		softAssertion = new SoftAssert();

	}

	@Given("^I go to amazon$")
	public void i_go_to_amazon() throws Throwable {
		driver.manage().deleteAllCookies();
		driver.get(data.getUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@And("^I login with my \"(.*?)\" and \"(.*?)\"$")
	public void i_login_with_my_and(String email, String password) throws Throwable {

		homePage.clickLnkSignIn();
		signInPage.performLogin(email, password);

		// Verify successful login by checking user_name
		softAssertion.assertTrue(homePage.getGreeting().contains(data.getUserName()));

	}

	@Then("^I Search for product: \"([^\"]*)\"$")
	public void i_Search_for_product(String firstProduct) throws Throwable {

		firstProduct = data.getFirstProduct();

		homePage.searchProduct(firstProduct);
	}

	@Then("^I Select first product and validate first price vs detail price$")
	public void i_Select_first_product_and_validate_first_price_vs_detail_price() throws Throwable {

		firstPrice = resultsPage.getFirstPrice();

		resultsPage.clickImgFirstProduct();

		String detailPrice = detailsPage.getDetailPrice();

		softAssertion.assertTrue(detailPrice.contains(firstPrice));
	}

	@When("^I click on Add to Cart$")
	public void i_click_on_Add_to_Cart() throws Throwable {
		detailsPage.clickBtnAddToCart();
	}

	@And("^Validate first price vs current price And validate Shop car has 1 item$")
	public void validate_first_price_vs_current_price_And_validate_Shop_car_has_item() throws Throwable {

		String cartPrice = containerPage.getCartPrice();
		strCartCount = containerPage.getCartCount();
		int cartCount = Integer.parseInt(strCartCount);

		softAssertion.assertTrue(cartPrice.contains(firstPrice));
		softAssertion.assertEquals(cartCount, 1);
	}

	@Then("^I Search for second product: \"([^\"]*)\"$")
	public void i_Search_for_second_product(String secondProduct) throws Throwable {

		secondProduct = data.getSecondProduct();

		homePage.searchProduct(secondProduct);
	}

	@And("^Select first product$")
	public void select_first_product() throws Throwable {
		resultsPage.clickImgFirstProduct();
	}

	@Then("^I add second product to the cart And verify cart has two items$")
	public void i_add_second_product_to_the_cart_And_verify_cart_has_two_items() throws Throwable {

		detailsPage.clickBtnAddToCart();
		strCartCount = containerPage.getCartCount();
		int cartCount = Integer.parseInt(strCartCount);
		softAssertion.assertEquals(cartCount, 2);
		containerPage.clickBtnCarrito();

		Thread.sleep(2000);
		softAssertion.assertAll();

	}

}
	
	


