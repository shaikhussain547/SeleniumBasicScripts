package Selenium_Part1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

	public static void main(String[] args) {
		//CSS selectors
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//1. Using ID writing css selector {#idvalue}
		driver.findElement(By.cssSelector("#email")).sendKeys("John547");
		
		//2. Using classname writing css selector {.classvalue} //not recommended
		
		//3. Using TagName and Id :- {TagName#idvalue}
		driver.findElement(By.cssSelector("input#pass")).sendKeys("John@123");
		
		//4. Using TagName and Class :- {TagName.classvalue}  //not recommended
		
		//5. Using TagName and Attribute :- {TagName[AttributeName='AttributeValue']}
		driver.findElement(By.cssSelector("button[name='login']")).click();
		
		//6. Starts with (^) :- TagName[AttributeName^='PrefixAttributeValue']
		driver.findElement(By.cssSelector("input[placeholder^='Email address']"));
		
		//7. Ends with ($) :- TagName[AttributeName$='SuffixAttributeValue']
		driver.findElement(By.cssSelector("input[placeholder$='or phone number']"));
		
		//8 Contains (*) :- TagName[AttributeName*='PartialAttributeValue']
		driver.findElement(By.cssSelector("input[placeholder*='or phone']"));
		
		//9. Direct Child (>) :- ParentLocator > ChildLocator
		//		Example:-	#u_0_2_RW > div > div > #email  		
		
		// 10. Descendents (Space) :-   Example:-  #u_0_2_RW #email
		
		//11. nth-of-type
//		Ex: #block_various_links_footer > ul > li:nth-of-type(3) > a
		
		//12. last-child
//		Ex:  #block_various_links_footer > ul > li:last-child	
		
		
		
		
		
		
	}

}
