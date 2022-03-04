package academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validatetestng extends Base {

	public static Logger Log = LogManager.getLogger(Validatetestng.class.getName());

	public WebDriver driver;
	@BeforeTest
	public void initTest() throws IOException {
		driver = initializeDriver();	
	}
	@Test()
	public void basePathNavigation() throws IOException, InterruptedException {
		
		Log.info("Driver Initialized");
		driver.get(getUrl());
		Log.info("Navigated to qa click academy");
		HomePagePO hp = new HomePagePO(driver);

		Assert.assertEquals(hp.getTitleEle().getText(), "FEATURED COURSES");

		Assert.assertTrue(hp.getNavBar().isDisplayed());
		

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();

	}


}
