package Selenium_Part1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Capture the screenshots:
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\HomePage1.png");
		FileUtils.copyFile(source, dest);
		
		//Capture the element screenshot:
		WebElement ele = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]"));
		source = ele.getScreenshotAs(OutputType.FILE);
		dest = new File(".\\Screenshots\\Element.jpeg");
		FileUtils.copyFile(source, dest);
	}

}
