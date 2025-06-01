package ecommerce;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ECommerce_tc_4_Hybrid extends EcommerceConfiguration {
	
	@Test
	public void FillForm() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Abhijeet Deshmukh");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ADD TO CART\"))"));
	    driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(1).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/totalAmountLbl"));
		
		int count = productPrices.size();
		
		double totalsum=0;
		
		for (int i=0; i<count; i++)
		{
			String amountString = productPrices.get(i).getText();
			//$160.07
			Double price =getFormatedAmount(amountString);
			totalsum = totalsum + price;// 160.97 + 120 = 280.97
		}
		
		
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormatedSum = getFormatedAmount(displaySum);
		Assert.assertEquals(totalsum, displayFormatedSum);
		
		WebElement longPress =driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(longPress);
		Thread.sleep(3000);
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		Set <String> contexts=driver.getContextHandles();
		for (String contexName : contexts)
		{
			System.out.println(contexName);
		}
		
      driver.context("WEBVIEW_com.androidsample.generalstore");// chrome driver
      driver.findElement(By.name("q")).sendKeys("facebook");
      driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
      driver.pressKey(new KeyEvent(AndroidKey.BACK));
      driver.context("NATIVE_APP");
		
      // pneding code
		
		//69.0.3497
		//Hybrid - Google page ->
		
	}

}
