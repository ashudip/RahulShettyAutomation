package Framework_test.Automation_framework;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework_test.BaseTest.BaseTest;

public class LoginTest extends BaseTest {

	
	@Test(dataProvider = "data")
	public void invalidlogin(HashMap<String,String>data)
	{
		log.logintoapplication(data.get("name"),data.get("password"));
		String msg = log.geterro();
		Assert.assertEquals(msg,"Incorrect email or password.");
	}
//	@Test
//	public void loginusername()
//	{
//		log.logintoapplication("ashudeepdv@gmail.com","Test@123");
//		String msg = log.geterro();
//		Assert.assertEquals(msg,"Incorrect email or password.");
//	}
	
	@DataProvider
	public Object[][] data() throws IOException
	{
		List<HashMap<String,String>>map=getjsondata(System.getProperty("user.dir")+"\\src\\test\\java\\Framework_test\\Data\\Invalidlogin.json");
		Object [][] arr ={{map.get(0)},{map.get(1)}};
		return arr;	
	}
	
	
}
