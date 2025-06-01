package basics;

import java.net.MalformedURLException;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{

	@Test
	public void scrollDemoTest() throws MalformedURLException, InterruptedException
	{
		//Approach 1
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))")).click();
		
		//Approach 2
		// Scroll down until we can't scroll anymore
		scrollToEndAction();

		

	}

}

/** Approach 1
 *Absolutely! Let’s break down this Appium line step-by-step in very simple language so you 
 *can explain it confidently in an interview:

✅ Code:
driver.findElement(AppiumBy.androidUIAutomator(
    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))")).click();
    
🔍 What is this doing?
This code scrolls vertically through an Android app until it finds an element with the text
 "Views", and then clicks on it.

🧩 Explanation (Part by Part):
✅ driver.findElement(...)
This tells Appium: “I want to find an element.”

✅ AppiumBy.androidUIAutomator(...)
You’re using Android's UIAutomator syntax here.

It's a powerful tool provided by Android for locating elements, especially useful 
for scrolling actions.

✅ "new UiScrollable(new UiSelector())"
This creates a scrollable container.

new UiSelector() means: "look in the default scrollable area".

✅ .scrollIntoView(text("Views"))
This tells the scrollable area: "Keep scrolling until you find an element with
the exact text 'Views'."

✅ .click()
Once the element is found, this will click on the 'Views' item.

📝 **Simple Summary (in your own words for an interview):
“This line of code scrolls through a scrollable screen until it finds the element with the 
text ‘Views’ and then clicks on it. It uses UIAutomator’s scrollIntoView method which is very 
helpful when the element is not visible on the screen initially.”* 

// Approach 2
///
///Sure! The code in your image is using JavaScript Executor in Appium to scroll down on a mobile screen 
// using "mobile: scrollGesture". Here's the full code written properly in Java:

✅ Java Code to Scroll Down using scrollGesture:
java
Copy
Edit
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

🧠 What does this code do?
It uses a JavaScript command to perform a scroll gesture on the screen.

It scrolls down again and again until no more scrolling is possible (canScrollMore becomes false).

🔍 Explanation of Parameters:

Parameter	Description
"left", 100	X position of scroll start point
"top", 100	Y position of scroll start point
"width", 200	Width of scroll area
"height", 200	Height of scroll area
"direction", "down"	Direction to scroll (can be "up", "down", "left", "right")
"percent", 3.0	How much to scroll (in % of the screen area)

💡 When to use this:

Use this when you're not able to use UiScrollable or the element is not found using text, 
and you want manual control over scroll in Appium.

Would you like an example where this scrolls up or until a specific element is found?







You said:
I want explain in interview. Can you explain


ChatGPT said:
Absolutely! Here's how you can explain this scroll code in very simple words during an interview:

✅ Interview Explanation: Scroll using scrollGesture in Appium
"In some cases, I use JavaScriptExecutor in Appium to perform scrolling actions when the element 
is not directly visible or when UiScrollable doesn't work properly.
Here's how I do it:"

🧩 Step-by-step Explanation:
I first create a boolean variable called canScrollMore to keep track of whether more scrolling 
is possible.

Then I use a do-while loop to scroll the screen down continuously.

Inside the loop, I use:

((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ...)
This is a special way to run mobile gestures like scrolls using JavaScript in Appium.

I pass a map of options like:

"direction": "down" – I want to scroll down.

"percent": 3.0 – I scroll by 3% of the screen each time.

"left", "top", "width", "height" – These define the area of the screen where the scroll will happen.

This scrolls again and again until there's nothing more to scroll, and canScrollMore becomes false.

📝 In one line (quick summary for interview):
"This code performs a scroll down gesture on the screen using JavaScript Executor in Appium, 
and keeps scrolling until there's no more content to scroll."
 */




