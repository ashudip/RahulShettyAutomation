package Framework_test.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework_test.Utilities.BaseClass;

public class CheckoutPOM extends BaseClass{

	WebDriver driver;
	public CheckoutPOM(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/*driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("india");
	List<WebElement>country=driver.findElements(By.xpath("//button[@class=\"ta-item list-group-item ng-star-inserted\"]"));
	for(int i =0;i<country.size();i++)
	{
		if(country.get(i).getText().equalsIgnoreCase("India"))
		{
			country.get(i).click();
			
		}
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//a[@class=\"btnn action__submit ng-star-inserted\"]")));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@class=\"btnn action__submit ng-star-inserted\"]")).click();*/
	
	@FindBy(xpath = "//input[@placeholder=\"Select Country\"]")
	WebElement countrydropdown;
	
	@FindBy(xpath ="//button[@class=\"ta-item list-group-item ng-star-inserted\"]" )
	List<WebElement> countrylist;
	
	@FindBy(xpath = "//a[@class=\"btnn action__submit ng-star-inserted\"]")
	WebElement plcordbtn;
	
	public void selectcountry(String countryname)
	{
		countrydropdown.sendKeys(countryname);
		for(int i =0;i<countrylist.size();i++)
		if(countrylist.get(i).getText().equalsIgnoreCase("India"))
		{
			countrylist.get(i).click();
			
		}
	}
	
	public ThankyouPOM placeorder() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//a[@class=\"btnn action__submit ng-star-inserted\"]")));
		Thread.sleep(1000);
		plcordbtn.click();
		ThankyouPOM ty = new ThankyouPOM(driver);
		return ty;
	}
}
