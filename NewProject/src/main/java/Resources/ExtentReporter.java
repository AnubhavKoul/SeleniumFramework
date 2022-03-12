package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		/*extent spark reporter class expects a path where you want to create the report.
		It is responsible for basic configurations of the report. */
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		//Extent Report class object will be responsible for all configurations.
		reporter.config().setReportName("Automation Run Report");
		reporter.config().setDocumentTitle("Anubhav Framework Extent Report");
		
		//Extent Report class is responsible to consolidate all run into a single report to display
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
	}

}
