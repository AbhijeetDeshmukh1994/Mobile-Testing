package basics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class WifiSettingName extends BaseTest{

	@Test
	public  void wifiSettingTest() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/checkbox")).click();
		//DeviceRotation landScape = new DeviceRotation(0,0,90);
		//driver.rotate(landScape);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		Thread.sleep(3000);
		String title= driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "WiFi settings");
		//copy-paste
		//copy to clipboar 
		driver.setClipboardText("Abhijeet wifi");
		//paste to clipboard.
	    driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/button2")).click();
	}

}
