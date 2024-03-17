package Framework_test.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Framework_test.Utilities.BaseClass;

public class CartpagePOM extends BaseClass {

	WebDriver driver;

	public CartpagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//div[@class=\"infoWrap\"]")
	List<WebElement> productnames;

	@FindBy(xpath = "//div[@class=\"infoWrap\"]//h3")
	List<WebElement> cartpronames;
	
	@FindBy(xpath = "//div[@class=\"infoWrap\"]//button[@class=\"btn btn-primary\"]")
	List<WebElement>cartprodbtn;
	
	public CheckoutPOM clickonbuynowbtn(String acttext) {
		for (int i = 0; i < productnames.size(); i++) {
			if(cartpronames.get(i).getText().equalsIgnoreCase(acttext))
			{
				cartprodbtn.get(i).click();
			}
		}
		CheckoutPOM ch = new CheckoutPOM(driver);
		return ch;
	}
}
