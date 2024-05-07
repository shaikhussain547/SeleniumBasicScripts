package Selenium_Part1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseInteractions {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Execution started");
		WebElement ele = driver.findElement(By.linkText("More"));
		Point point = ele.getLocation();
		
		Actions actions = new Actions(driver);		
//		actions.moveByOffset(point.getX(), point.getY()).build().perform();    --(Not worked)
//		actions.moveToElement(ele).build().perform();
//		actions.moveToElement(ele).click().build().perform();
//		actions.click(ele).build().perform();
		
		//Keyboard based interactions::
		//KeyDown :- Pressing the key, KeyUp :- Releasing the key
//		actions.keyDown(Keys.CONTROL).sendKeys("f").build().perform();  --(Not worked)
		
		System.out.println("Execution completed");
		
	}

}
