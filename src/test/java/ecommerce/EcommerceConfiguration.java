package ecommerce;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class EcommerceConfiguration {
	
     public AppiumDriverLocalService service;
     public  AndroidDriver driver;
     
     @BeforeClass
	public  void configureAppium() throws MalformedURLException, URISyntaxException
	{
		 service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//Eternity//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723).build();
		
		//service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AbhijeetDeshmukh");
		options.setApp("D://WorkSpace//Appium//src//test//java//resources//General-Store.apk");
		// Appium code -> Appium server -> Mobile
		 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
     
     public void longPressAction(WebElement ele)
     {
    	 ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
 				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
 						"duration",2000));
     }
     
     public  void scrollToEndAction()
     {
    		// Scroll down until we can't scroll anymore
 		boolean canScrollMore;

 		do {
 		    canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
 		        "mobile: scrollGesture",
 		        ImmutableMap.of(
 		            "left", 100,
 		            "top", 100,
 		            "width", 200,
 		            "height", 200,
 		            "direction", "down",
 		            "percent", 3.0
 		        )
 		    );
 		} while (canScrollMore);
     }
     
     public void swipeAction(WebElement ele, String direction)
     {
    	 ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
 			    "elementId", ((RemoteWebElement) ele).getId(),
 			    "direction", direction,
 			    "percent", 0.75
 			));
     }
     
     public Double getFormatedAmount(String amount)
     {
    	 Double price =Double.parseDouble(amount.substring(1));
    	 return price;
     }
     
     
	
     @AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
}
