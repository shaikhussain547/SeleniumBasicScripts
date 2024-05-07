package Selenium_Part1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTablePart1 {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Print a full table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));	
		System.out.println(rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));	
		System.out.println(columns.size());
		
		for(int row=1; row<=1; row++){
			for(int cell=1; cell<=columns.size(); cell++) {
				WebElement eachCell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+row+"]/th["+cell+"]"));
				System.out.print(eachCell.getText()+"           ");	
			}
			System.out.println();
		}
		
		for(int row=2; row<=rows.size(); row++){
			for(int cell=1; cell<=columns.size(); cell++) {
				WebElement eachCell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+row+"]/td["+cell+"]"));
				System.out.print(eachCell.getText()+"           ");
			}
			System.out.println();
		}
	}
	
	/*
	 * 1. Need row count to iterate all the rows.
	 * 2. Need column count to iterate each cell of a row.
	 * 3. Write two for loops i.e, one for rows and one for columns.
	 * 4. Write xpath to fetch each row and corresponding cell data.
	 */

}
