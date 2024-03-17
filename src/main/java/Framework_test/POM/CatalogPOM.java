package Framework_test.POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Framework_test.Utilities.BaseClass;

public class CatalogPOM extends BaseClass{

	/*List<WebElement>cards = driver.findElements(By.xpath("//div[@class=\"card\"]"));
	for(int i =0;i<cards.size();i++)
	{
		String text = driver.findElements(By.xpath("//div[@class=\"card-body\"]//b")).get(i).getText();
		if(text.equalsIgnoreCase(actuatext))
		{
			driver.findElement(By.xpath("//button[@class=\"btn w-10 rounded\"]")).click();
		}
		
	}
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id=\"toast-container\"]"))));
	driver.findElement(By.xpath("")).click();
	*/
	WebDriver driver;
	public CatalogPOM(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath = "//div[@class=\"card\"]")
	List<WebElement>products;
	
	//@FindBy(css = ".ng-animating")
	By spinner = By.cssSelector(".ng-animating");
	
	@FindBy(xpath = "//div[@id=\"toast-container\"]")
	WebElement tastmsg;
	
	By toastmsg  =By.xpath("//div[@id=\"toast-container\"]");
	
	@FindBy (xpath = "//div[@class=\"card-body\"]//b")
	List<WebElement>prodnames;
	
	@FindBy(xpath = "//button[@class=\"btn w-10 rounded\"]")
	List<WebElement>prodbtns;
	
	public CartpagePOM selectproduct(String actuatext)
	{
		for(int i =0;i<products.size();i++)
		{
			if(prodnames.get(i).getText().equalsIgnoreCase(actuatext))
			{
				prodbtns.get(i).click();
			}
			
		}
		System.out.println("waiting for spinner");
		waitforelementinvisibility(spinner);
		//System.out.println("waitng for toast");
		//waitforelementvisibility(tastmsg);
		clickcartlink();
		CartpagePOM cartp = new CartpagePOM(driver);
		return cartp;
	}
	
	
}
