package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportstest {
	ExtentReports ep;
	ExtentTest et;
	@BeforeTest
	public void beforetest() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter esp = new ExtentSparkReporter(path);
		esp.config().setDocumentTitle("QATEST");
		esp.config().setReportName("WEB report");
		ep = new ExtentReports();
		ep.attachReporter(esp);
		 et = ep.createTest("Test");
		
	}

	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());
		et.fail("failed to test");
		//et.pass("test passed");
		et.log(Status.INFO,"gettting the test title="+driver.getTitle());
		ep.flush();
		
	}
}