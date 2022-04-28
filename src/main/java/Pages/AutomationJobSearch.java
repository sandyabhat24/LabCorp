package Pages;

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
import org.testng.Assert;

public class AutomationJobSearch {

	WebDriver driver;
	Actions action;
		
		public AutomationJobSearch(WebDriver driver) {
			this.driver=driver;
		}
		
	@FindBy(how=How.XPATH, using="//div[@data-ph-id=\"ph-view3-1649324224799-ph-facets-v1x25c65-iS0o9i\"]//following::button[@data-ph-at-text='State/Province']") WebElement STATE_FILTER;
	@FindBy(how=How.XPATH,using="//input[@id='facetInput_1']") WebElement STATE_TEXT_BOX;
	@FindBy(how=How.XPATH, using=("//*[contains(text(),' hands-on test automation or development experience')]")) List<WebElement> EXPERIENCE;
	
	@FindBy(how=How.XPATH,using="//div[@class='job-bottom-action']/a") WebElement APPLY_JOB;
	
	public void clickState()
	{
	
		STATE_FILTER.click();
		STATE_TEXT_BOX.sendKeys("North Carolina");
		STATE_TEXT_BOX.click();
		
	}
	
	public void switchWindowAndAssert() {
		String str=" hands-on test automation or development experience";
		String currentURL;
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			currentURL=driver.getCurrentUrl();
			System.out.println(currentURL);
			if(currentURL.contains("Automation")) {
			for(int i=0;i<EXPERIENCE.size();i++) {
				
				Assert.assertEquals(driver.getPageSource().contains(str), true);
					APPLY_JOB.click();
			}
			
			
		}
		}
		
		/*String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);*/
	} 
	
}
