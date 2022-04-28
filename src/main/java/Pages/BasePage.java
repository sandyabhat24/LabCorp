package Pages;

import java.util.HashMap;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
	
	static WebDriver driver;
	static String url="https://www.labcorp.com/";
	
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		Map < String, Object > prefs = new HashMap < String, Object > ();
	    Map < String, Object > profile = new HashMap < String, Object > ();
	    Map < String, Integer > contentSettings = new HashMap < String, Integer > ();
	    contentSettings.put("geolocation", 1);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    options.setExperimentalOption("prefs", prefs);
	
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
