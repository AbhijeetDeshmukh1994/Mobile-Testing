package basics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest{

	@Test
	public void dragDropDemoTest() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))")).click();
		Thread.sleep(3000);
	
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		Thread.sleep(3000);
		
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		 ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
	 			    "elementId", ((RemoteWebElement) source).getId(),
	 			    "endX", 712,
	 			    "endY", 639
	 			));
		 Thread.sleep(3000);
		 
		 String dropedText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		 Assert.assertEquals(dropedText, "Dropped!");
		 Thread.sleep(3000);
		 
	}

}






