package Selenium_Part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomXpath {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		//Relative Xpath:
		//1. Single Attribute
		//tagName[@attributeName = 'AttributeValue']
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("John547");
		
		//2. Double Attribute
		//tagName[@attributeName1 = 'AttributeValue1'][@attributeName2 = 'AttributeValue2']
		driver.findElement(By.xpath("//input[@id='pass'][@placeholder='Password']")).sendKeys("John123");
		
		//3. Using AND
		//tagName[@attributeName1 = 'AttributeValue1' and @attributeName2 = 'AttributeValue2']
		driver.findElement(By.xpath("//button[@name='login' and @type='submit']")).click();
		
		//4. Using OR
		//tagName[@attributeName1 = 'AttributeValue1' or @attributeName2 = 'AttributeValue2']
		String ErrorMsg = driver.findElement(By.xpath("//*[@id='error_box' or @role='alert']/div[1]")).getText();
		System.out.println(ErrorMsg);
		
		//5. contains()
		//tagName[contains(@attributeName, 'PartialAttributeValue')]
		driver.findElement(By.xpath("//input[contains(@placeholder,'or phone number')]")).clear();
		
		//6. starts-with()
		//tagName[starts-with(@attributeName, 'StartingPartialAttributeValue')]
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Email address or')]")).clear();
		
		//7. text()
		//tagName[text()='visibleText']
		driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
		
		//8. last()
		//tagName[@attributeName = 'AttributeValue'])[last()]
		
/*			
 * 			Example:-  (//input[@type='text'])[last()]
 * 			To identify last but one element === //tagName[@attributeName = 'AttributeValue'])[last()-1]
 * 			Example:-  (//input[@type='text'])[last()-1]
 * 
 */
		//9. position()
		//tagName[@attributeName = 'AttributeValue'])[position() = 2]
// 				or
		//tagName[@attributeName = 'AttributeValue'])[2]
/*
 * 		Example:-  (//input[@type='text'])[position()=1]
 * 		Example:-  (//input[@type='text'])[1]
 */
		//10. index
		
		//11. following-sibling
		//tagName[@attributeName = 'AttributeValue']/following-sibling::FollowingSiblingTagName
		
		//12. preceding-sibling
		//tagName[@attributeName = 'AttributeValue']/preceding-sibling::PrecedingSiblingTagName
		
		//13. parent
		//tagName[@attributeName = 'AttributeValue']/parent::ParentTagName
		//a[@title='Specials']/parent::li/parent::ul/preceding-sibling::h4
		//a[@title='Specials']/../../preceding-sibling::h4
		
		//14. Identify descendents using // ul element
		//h4[text() = 'Information']/following-sibling::ul//a[@title='Specials']
		
		//Normalize-space
		//div[normalize-space(text())='Powered by']
	}

}
