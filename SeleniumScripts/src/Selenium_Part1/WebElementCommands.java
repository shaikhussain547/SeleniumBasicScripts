package Selenium_Part1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementCommands {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement element = driver.findElement(By.linkText("Forgotten password?"));		
		System.out.println(element.getAttribute("href"));
		
		Point varLocatation = element.getLocation();
		System.out.println(varLocatation.getX());
		System.out.println(varLocatation.getY());
		
		Dimension varSize = element.getSize();
		System.out.println(varSize.getHeight());
		System.out.println(varSize.getWidth());
		
		
		
	}

}
