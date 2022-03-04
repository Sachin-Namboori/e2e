package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePO extends Base {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@id=\'user_email\']")
	WebElement emailid;
	
	@FindBy(xpath="//input[@id=\'user_password\']")
	WebElement password;
	
	@FindBy(css="[value=\'Log In\']")
	WebElement clicki;
	
	public LoginPagePO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getemailID() {
		
		return emailid;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getBtn() {
		return clicki;
	}
}
