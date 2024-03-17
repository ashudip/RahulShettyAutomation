package Framework_test.Automation_framework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Framework_test.BaseTest.BaseTest;
import Framework_test.BaseTest.Retry;
import Framework_test.POM.CartpagePOM;
import Framework_test.POM.CatalogPOM;
import Framework_test.POM.CheckoutPOM;
import Framework_test.POM.LoginPOM;
import Framework_test.POM.ThankyouPOM;

public class E2Etest extends BaseTest {

	@Test(dataProvider = "data",retryAnalyzer = Retry.class)
	public void submitorder(HashMap<String,String>map) throws InterruptedException, IOException
	{
		String actuatext=map.get("product");
		CatalogPOM cp = log.logintoapplication(map.get("email"),map.get("password"));
		tlocal.get().log(Status.INFO,"entered username and password");
		CartpagePOM cart= cp.selectproduct(actuatext);
		tlocal.get().info("Selected the product");
		CheckoutPOM checkp= cart.clickonbuynowbtn(actuatext);
		checkp.selectcountry("India");
		ThankyouPOM ty = checkp.placeorder();
		tlocal.get().log(Status.INFO,"placed the order");
		String msg = ty.getthankyoumsg();	
		Assert.assertEquals(msg,"THANKYOU FOR THE ORDERs.");
	}
	
	@DataProvider
	public Object[][] data() throws IOException
	{
//		HashMap<String,String>map = new HashMap<String, String>();
//		map.put("name","ashudeepdev@gmail.com");
//		map.put("password","Test@123");
//		map.put("product","ADIDAS ORIGINAL");
//		
//		HashMap<String,String>map1=new HashMap<String, String>();
//		map1.put("name","ashudeep_devari@persistent.com");
//		map1.put("password","Test@123");
//		map1.put("product","ZARA COAT 3");
		
		List<HashMap<String,String>>map=getjsondata(System.getProperty("user.dir")+"\\src\\test\\java\\Framework_test\\Data\\Login.json");
		Object[][] arr= {{map.get(0)}};
		return arr;
		
	}
	
}
