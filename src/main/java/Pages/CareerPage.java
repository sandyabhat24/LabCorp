package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CareerPage {

WebDriver driver;
Actions action;
	
	public CareerPage(WebDriver driver) {
		this.driver=driver;
	}
	
@FindBy(how=How.XPATH,using="//div[@data-ph-id='ph-widget-element-1646165565244-121']/descendant::input") WebElement CAREERS_SEARCH_BUTTON;
@FindBy(how=How.XPATH, using="//div[@data-ph-id='ph-page-element-page11-977dcP']//a") List<WebElement> JOB_LIST;
@FindBy(how=How.XPATH, using="//div[@data-ph-id='ph-page-element-page11-977dcP']//span[@class='job-location']") List<WebElement> JOB_LOCATION;


	
	public void enterSearchTextInSearchBox(Set<String> window) {
		
		      Iterator<String> it=window.iterator();
				String parent=it.next();
				String child=it.next();
				driver.switchTo().window(child);
				CAREERS_SEARCH_BUTTON.sendKeys("QA Automation Tester");
				
				//SEARCH_CLICK.click();			
		action=new Actions(driver);
		action.moveToElement(CAREERS_SEARCH_BUTTON).sendKeys(Keys.ENTER).click().build().perform();
	}
	
	public void jobList() {
		List<String> automationRole=new ArrayList<String>();
		for(int i=0;i<JOB_LIST.size();i++) {
			String opentab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			if(JOB_LIST.get(i).getText().contains("Test Automation Engineer") && JOB_LOCATION.get(i).getText().contains("North Carolina")) {
				JOB_LIST.get(i).sendKeys(opentab);
				
			}
	        
		}
		
	}
	
}
