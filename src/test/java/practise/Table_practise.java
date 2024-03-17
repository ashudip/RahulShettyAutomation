package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Table_practise {
	//div[@class="tableFixHead"]//td[4]
	WebDriver driver;
	@Test
	public void scroll() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,800)");
//		
//		//scroll in table
//		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,200)");
//		Thread.sleep(500);
	
	
	   List<WebElement>td= driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]//td[4]"));
		System.out.println(td.get(3).getText());
	   int sum=0;
	    for(int i=0;i<td.size();i++)
	    {
	    	
	    	sum=sum+Integer.parseInt(td.get(i).getText());
	    }
	    System.out.println(sum);
	    String amt =driver.findElement(By.xpath("//div[@class=\"totalAmount\"]")).getText();
	    String[] newone = amt.split(":");
	    Assert.assertEquals(sum,Integer.parseInt(newone[1].trim()));
	    
		driver.close();
		
	}
	
}
