package Selenium_Part1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//https://bugbug.io/blog/software-testing/best-selenium-practice-websites/
		//https://the-internet.herokuapp.com/
		//https://demoqa.com/
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('userName').value='John Wick';");
//		js.executeScript("document.getElementByName('userName')[0].value='Hussain';");  --> Example
		js.executeScript("document.getElementsByClassName('mr-sm-2 form-control')[1].value='sdet.qa@gmail.com';");
//		js.executeScript("document.getElementsByTagName('b')[0].click();");  --> Example
		js.executeScript("document.querySelector('#currentAddress').value='Hyderrabad, Pin:223344';");
		js.executeScript("document.evaluate(\"//button[@id='submit']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
		System.out.println("Completed");
		
		
	}
/*	
 * JavaScript Executor
 * 1. Find elements using JS Executor
 * 2. Enter text into textbox using JS Executor
 * 3. Click element using JS Executor
 * 4. Highlight element using JS Executor
 * 5. Scroll using JS Executor
 *  
 * Xpath::- document.evaluate(xpath, contextNode, nameSpaceResolver, resultType, result).singleNodeValue;
 * document.evaluate("//input[@id='username']", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
 */

}
