package bike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class KTMTest {
	@Test
	public void launch() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ktmindia.com/");
		Reporter.log("KTM Lunch",true);
	}

}
