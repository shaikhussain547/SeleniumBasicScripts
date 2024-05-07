package Selenium_Part1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutorConcept2 {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		
		js.executeScript("arguments[0].value='John';", fullName);
		js.executeScript("arguments[0].setAttribute('value', 'sdet2qa@gmail.com')", email);
		js.executeScript("arguments[0].setAttribute('style','border: 5px red solid');", fullName);
		//document.getElementById('userName').setAttribute('style','border: 2px green solid');
		
		js.executeScript("window.scroll(0, 1300);");
		//scroll or scrollTo are same
		//scrollBy
		//scrollIntoView()
		
		
		
	}

}
