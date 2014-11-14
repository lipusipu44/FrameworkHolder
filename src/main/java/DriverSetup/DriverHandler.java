package DriverSetup;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DriverHandler {
	public static HashMap<String,DriverCall> instanceStorage=new HashMap<String,DriverCall>();
	public static WebDriver driver;
	int timeOutSecond=40;

	public static WebDriver initiateDriver(String userName,String browserName){
		
		if(instanceStorage.containsKey(userName)){
			return instanceStorage.get(userName).getDriver(driver);
		}
		DriverCall driverCall=new DriverCall(browserName);
		driver=driverCall.createNewDriver();
		instanceStorage.put(userName, driverCall);
		return driver;
	}
	
	public static void shutDownAll(){
		for(DriverCall userRemoval:instanceStorage.values()){
			userRemoval.getDriver(driver).close();
		}
	}
	
	public static void shutDown(String userName){
		if(instanceStorage.containsKey(userName)){
			instanceStorage.get(userName).getDriver(driver).close();
			return;
		}
		else
			new NoSuchElementException("Driver is not created");
	}
}
