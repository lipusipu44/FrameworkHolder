package DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


final public class DriverCall {

	enum BrowserType{
		GC("Google Chrome"),IE("Internet Explorer"),FF("FireFox");
		private String BrowserName;
		private BrowserType(String name) {
			BrowserName=name;
		}
		public String getBrowserName(){
			return BrowserName;

		}
	}

	public WebDriver driver;
	public String BrowserName;
	BrowserType browserType = null;

	DriverCall(String browserName){
		if(browserName.equalsIgnoreCase("gc"))
			browserType=BrowserType.GC;
		else if(browserName.equalsIgnoreCase("ie"))
			browserType=BrowserType.IE;
		else if(browserName.equalsIgnoreCase("ff"))
			browserType=BrowserType.FF;
	}

	public String getBrowserName(){
		return browserType.getBrowserName();
	}

	public WebDriver createNewDriver(){
		switch(browserType){
		case GC:
			System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
			return driver;
		case FF:
			driver=new FirefoxDriver();
			return driver;
		case IE:
			driver=new InternetExplorerDriver();
			return driver;
		default:
			driver=new ChromeDriver();
			return driver;
		}

	}

	public WebDriver getDriver(WebDriver driver){
		if(driver!=null)
			return driver;
		else 
			throw new WebDriverException();

	}

	public void closeDriver(WebDriver driver){
		driver.close();
	}

}
