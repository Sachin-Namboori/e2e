package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePage extends Base  {

	@BeforeTest
	public void initTest() throws IOException {
		driver = initializeDriver();	
	}

	
	@Test(dataProvider="getData")
	public void basePathNavigation(String email, String passwd) throws IOException, InterruptedException {
	
		
		driver.get(getUrl());
		HomePagePO hp = new HomePagePO(driver);
	
		hp.getLogin().click();
		
		LoginPagePO lp = new LoginPagePO(driver);
		lp.getemailID().sendKeys(email);
		lp.getPassword().sendKeys(passwd);
		
		lp.getBtn().click();
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Restricted_user@dd.com";
		data[0][1]="Test1";
	
		data[1][0] = "NonRestricted_user@dd.com";
		data[1][1]="Test1";
	
	
	
	
	
	return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();

	}
	
}
