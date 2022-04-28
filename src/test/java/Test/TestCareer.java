package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.AutomationJobSearch;
import Pages.BasePage;
import Pages.CareerPage;
import Pages.LC_HomePage;

public class TestCareer extends BasePage {

	WebDriver driver;
	
	@Test
	public void lCTestCarrer() throws InterruptedException {
		driver=BasePage.init();
		LC_HomePage homepage=PageFactory.initElements(driver, LC_HomePage.class);
		CareerPage careerpage=PageFactory.initElements(driver, CareerPage.class);
		homepage.click_CareerLink();
		careerpage.enterSearchTextInSearchBox(homepage.switchWindow());
		AutomationJobSearch jobsearch=PageFactory.initElements(driver, AutomationJobSearch.class);
		jobsearch.clickState();
		Thread.sleep(1000);
		careerpage.jobList();
		jobsearch.switchWindowAndAssert();
		
	}
	
}
