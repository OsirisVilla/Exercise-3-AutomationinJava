package stepDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks {

	public static WebDriver driver;
	
    @Before
    public void initializeTest(){
    	driver = new ChromeDriver();
        
    }
 
    @After
    public void embedScreenshot(Scenario scenario) {
        driver.quit();
    }

}
