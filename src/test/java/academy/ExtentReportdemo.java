package academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportdemo {
	public static ExtentReports extent;
	
	public static ExtentReports getExtentObect() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Framework Report");
		reporter.config().setDocumentTitle("Test Outcomes");
		System.out.println("This is kool");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sachin Namboori");
	return extent;
	}
	
	
	
}
