package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LC_HomePage {

	WebDriver driver;
	
	public LC_HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='show-for-tablet-only mobile-utility']//a[@class='no-ext ext']") WebElement CAREERS;
	@FindBy(how=How.XPATH,using="//div[@id='onetrust-button-group']/button[2]") WebElement cookie_button;
	
	public void click_CareerLink() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", cookie_button);
		
		jse.executeScript("arguments[0].click()", CAREERS);
	
	}
	
	public Set<String> switchWindow() {
		Set<String> window=driver.getWindowHandles();
		
		return window;
	}
	
public void url() {
		System.out.println(driver.getCurrentUrl());
	}
}
