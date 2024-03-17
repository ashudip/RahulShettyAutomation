package practise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {

	@Test
	public void windowhan()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@target=\"_blank\"]")).click();
		Set<String>allwindows=driver.getWindowHandles();
		Iterator<String>it=allwindows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		String[] newtext = text.split(" ");
		System.out.println(newtext[4]);
		driver.close();
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(newtext[4]);
		
		
		
		
	}
}
