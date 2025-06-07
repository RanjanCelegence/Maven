package extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {
	@Test
	public void createReport() {
		String time = LocalDateTime.now().toString().replace(":","-");
		//Step:1 Create Extent Spark Reporter object
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Reports/ExtentReports_"+time+".html");
		
		//Step:2 Create extent reports object
		
		ExtentReports eReport=new ExtentReports();
		
		//Step:3 attach ExtentSparkReporter to ExtentReports
		eReport.attachReporter(spark);
		
		//Step:4 create ExtentTest object
		ExtentTest test=eReport.createTest("createReport");
		
		//Step:5 call log(status,"msg")
		test.log(Status.PASS, "log msg is added into report");
		
		//Step:6 call flash()
		eReport.flush();
	}

}
