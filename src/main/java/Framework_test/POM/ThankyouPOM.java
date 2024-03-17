package Framework_test.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Framework_test.Utilities.BaseClass;

public class ThankyouPOM extends BaseClass {

	WebDriver driver;
	public ThankyouPOM(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	@FindBy(xpath = "//h1[@class=\"hero-primary\"]")
	WebElement thankyoumsg;
	
	public String getthankyoumsg()
	{
		return thankyoumsg.getText();
	}
	
}
