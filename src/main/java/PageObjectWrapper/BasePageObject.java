package PageObjectWrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject {
	
	
	public <E> E getPageObject(Class<E> page,WebDriver driver){
		return PageFactory.initElements(driver, page);
		
	}
}
