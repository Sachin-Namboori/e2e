package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePO extends Base {

	public WebDriver driver;
	private By signinlink = By.cssSelector("a[href*=\'sign_in\']");
	private By title = By.cssSelector("div[class='text-center'] h2");
	private By navbar = By.cssSelector(".navbar-collapse.collapse");
	
	public HomePagePO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement getLogin() {
		
		return driver.findElement(signinlink);
	}
	
	public WebElement getTitleEle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navbar);
	}
}
