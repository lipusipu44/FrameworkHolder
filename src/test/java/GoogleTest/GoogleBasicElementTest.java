package GoogleTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DriverSetup.DriverHandler;

public class GoogleBasicElementTest {
	public WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver=DriverHandler.initiateDriver("anil", "gc");
		
	}

	@Test
	public void gmailElementSearch() throws Exception{
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		
	}
	
	@AfterClass
	public void tearDown(){
		DriverHandler.shutDown("anil");
	}
}
