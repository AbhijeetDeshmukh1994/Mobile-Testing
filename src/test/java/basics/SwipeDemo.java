package basics;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest{

	@Test
	public void swipeDemoTest() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))")).click();
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Gallery\"))")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		Thread.sleep(3000);
		
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getDomAttribute("focusable"),"true");
		// swipe
		swipeAction(firstImage,"left");

		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getDomAttribute("focusable"),"false");
		Thread.sleep(3000);
	}

}






