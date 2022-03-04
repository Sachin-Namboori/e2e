package academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

public WebDriver driver;

public String getUrl() throws IOException {

return url;
}

public String url;
	public WebDriver initializeDriver() throws IOException {
	Properties prop = new Properties();
	 String current = System.getProperty("user.dir");
	FileInputStream fis = new FileInputStream(current+"\\src\\main\\java\\academy\\data.properties");
	prop.load(fis);
//	String browserName = prop.getProperty("browser");
	String browserName = System.getProperty("browser");
	
	url = prop.getProperty("url");
	
	
	

	
	if(browserName.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
	}
	
	else if(browserName.equalsIgnoreCase("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		

	}
	
	else if (browserName.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
	
	driver = new EdgeDriver();
	
	}

	else{
		System.out.println("Browser "+ browserName +" Not Currently Handled");
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	}

public String getScreenshotcode(String testCaseName, WebDriver driver) throws IOException {
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	
	File src = ts.getScreenshotAs(OutputType.FILE);
	String destFile = System.getProperty("user.dir") +"\\reports\\" + testCaseName+ ".png";
	FileUtils.copyFile(src, new File(destFile));	
return destFile;
}
	
	}
