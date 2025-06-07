package extentreports;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddingScreenshotIntoReport {
	@Test
	public void addScreenshot() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.flipkart.com/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		
				//Step:1 Create Extent Spark Reporter object
				ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Reports/screenshotreport.html");
				
				//Step:2 Create extent reports object
				
				ExtentReports eReport=new ExtentReports();
				
				//Step:3 attach ExtentSparkReporter to ExtentReports
				eReport.attachReporter(spark);
				
				//Step:4 create ExtentTest object
				ExtentTest test=eReport.createTest("addScreenshot");
				
				//Step:5 call log(status,"msg")
				test.log(Status.INFO, "adding screenshot into report");
				test.addScreenCaptureFromBase64String(screenshot);
				
				//Step:6 call flash()
				eReport.flush();
	}

}
