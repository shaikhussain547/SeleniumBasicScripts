package Selenium_Part1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTablePart2 {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
/*		
		String Country = "Angola";
		String VisitedXpath = "//table[@id='countries']/tbody/tr/td/strong[text()='"+Country+"']/parent::td/preceding-sibling::td/input";
		driver.findElement(By.xpath(VisitedXpath)).click();
*/		
		String Countries[] = {"Argentina","Armenia","Austria","Bahrain"};
		for(String item : Countries) {
			driver.findElement(By.xpath("//table[@id='countries']/tbody/tr/td/strong[text()='"+item+"']/parent::td/preceding-sibling::td/input")).click();
		}
		System.out.println("Completed");
	}

}
