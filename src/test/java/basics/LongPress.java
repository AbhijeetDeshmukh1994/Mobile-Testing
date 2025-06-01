package basics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{

	@Test
	public  void LonPressGesture() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))")).click();

		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		Thread.sleep(2000);
		WebElement ele  =driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		longPressAction(ele);
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		Thread.sleep(2000);


		
		
	}

}
