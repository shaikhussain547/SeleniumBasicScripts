package Selenium_Part1;
//ExplicitWaitPart1
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationConcept {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//ExplicitWait :: WebDriverWait
	driver.findElement(By.xpath("//button[@id='alert']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),  Duration.ofSeconds(2));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		
		//ExplicitWait :: FluentWait
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		FluentWait wait1 = new FluentWait(driver);
		wait1.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
		wait1.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		String text1 = alert1.getText();
		alert1.accept();
		
	}

}
