package Selenium_Part1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTablePart3 {

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
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='countries']//tr"));
		System.out.println(rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='countries']//tr//h3"));
		System.out.println(columns.size());
		
		List<WebElement> hasVisited = driver.findElements(By.xpath("//table[@id='countries']//tr//td//input"));
		System.out.println(hasVisited.size());
			
		for(WebElement eachCheckBox : hasVisited) {
			js.executeScript("arguments[0].scrollIntoView();", eachCheckBox);
			eachCheckBox.click();
		}

		for(int row=2; row<=rows.size(); row = row+2) {
			WebElement eachCell = driver.findElement(By.xpath("//table[@id='countries']//tr["+row+"]//td[1]//input"));
			js.executeScript("arguments[0].scrollIntoView();", eachCell);
			eachCell.click();
			//table[@id='countries']//tr[position() mod 2=0]//td[1]//input
		}
		System.out.println("Completed");
			
	}

}
