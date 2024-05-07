package Selenium_Part1;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitPart2 {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

		//ExplicitWait
		driver.findElement(By.xpath("//button[@id='populate-text']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>(){
			@Override
			public Boolean apply(WebDriver t) {
				return driver.findElement(By.xpath("//h2[text()='Selenium Webdriver']")).isDisplayed();
			}
		};
		wait.until(func);
		WebElement text = driver.findElement(By.xpath("//h2[text()='Selenium Webdriver']"));
		System.out.println(text.getText());
		
		
	}

}
