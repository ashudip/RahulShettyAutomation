package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tablesolution {

	@Test
	public void checktable()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		List<WebElement>trows = driver.findElements(By.xpath("//div[@class=\"left-align\"]//table[@id=\"product\"]//tr"));
		System.out.println(trows.size());
		List<WebElement>tcols =driver.findElements(By.xpath("//div[@class=\"left-align\"]//table[@id=\"product\"]//th"));
		System.out.println(tcols.size());
		List<WebElement>tdata = driver.findElements(By.xpath("//div[@class=\"left-align\"]//table[@id=\"product\"]//td[3]"));
		int sum=0;
		for(int i = 0;i<tdata.size();i++)
		{
			sum=sum+Integer.parseInt(driver.findElements(By.xpath("//div[@class=\"left-align\"]//table[@id=\"product\"]//td[3]")).get(i).getText());
			
		}
		System.out.println(sum);
		driver.close();
	}
}
