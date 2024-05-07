package PracticeSmallScenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class acme_login {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Acme-test uipath login");
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("n130547rguktn@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Hyder#584");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement header = driver.findElement(By.xpath("//h1[@class='page-header']"));
		System.out.println(header.getText());
		Thread.sleep(2000);
		
		WebElement vendors = driver.findElement(By.xpath("//button[text()=' Vendors']"));
		Actions action = new Actions(driver);
		action.moveToElement(vendors).build().perform();
		driver.findElement(By.linkText("Vendor Inventory")).click();
		header = driver.findElement(By.xpath("//h1[@class='page-header']"));
		System.out.println(header.getText());
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.id("vendorTaxId")));
		select.selectByIndex(1);
		driver.findElement(By.id("buttonOrder")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		System.out.println(rows.size());
		System.out.println(rows.size()-1);
		Thread.sleep(2000);
		driver.close();
	}

}
