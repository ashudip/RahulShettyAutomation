package Framework_test.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Framework_test.POM.LoginPOM;

public class BaseTest {

	public LoginPOM log;
	public WebDriver driver;
	public static ExtentTest et;
	public static ThreadLocal<ExtentTest>tlocal = new ThreadLocal<ExtentTest>();
	public WebDriver initialise() throws IOException {
		Properties propr = new Properties();
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Framework_test\\Resources\\Global.properties");
		propr.load(fi);
		String browsername = propr.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}

	public List<HashMap<String, String>> getjsondata(String filepath) throws IOException {
		// read json file to convert to string
		String jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

		// convert string to hashmap
		ObjectMapper ob = new ObjectMapper();
		List<HashMap<String, String>> data = ob.readValue(jsoncontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getscreenshot(String tcname,WebDriver driver) throws IOException {
		TakesScreenshot tc = (TakesScreenshot) driver;
		File soure = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\reports\\" + tcname + ".png");
		FileUtils.copyFile(soure, dest);
		return System.getProperty("user.dir") + "\\reports\\" + tcname + ".png";
	}

	public static ExtentReports getreport() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter exp = new ExtentSparkReporter(path);
		exp.config().setReportName("Web automation");
		exp.config().setDocumentTitle("REPORT");
		ExtentReports ep = new ExtentReports();
		ep.attachReporter(exp);
		
		return ep;
		
	}

	@BeforeMethod
	public LoginPOM launchapp() throws IOException {
		driver = initialise();
		log = new LoginPOM(driver);
		log.gotourl();
		return log;
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
