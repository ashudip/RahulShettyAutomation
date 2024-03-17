package Framework_test.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework_test.Utilities.BaseClass;

public class LoginPOM extends BaseClass{

	WebDriver driver;
	public LoginPOM(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//input[@id=\"userEmail\"]")
	WebElement useremail;
	
	@FindBy(xpath = "//input[@id=\"userPassword\"]")
	WebElement password;
	
	@FindBy(xpath = "//input[@id=\"login\"]")
	WebElement lognbtn;
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement errormsg;
	
	public void gotourl() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public CatalogPOM logintoapplication(String name,String pass)
	{
		useremail.sendKeys(name);
		password.sendKeys(pass);
		lognbtn.click();
		CatalogPOM cp = new CatalogPOM(driver);
		return cp;
	}
	
	public String geterro() {
		waitforelementvisibility(errormsg);
		return errormsg.getText();
	}
	
}
