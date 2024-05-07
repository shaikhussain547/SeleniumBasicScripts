package PracticeSmallScenarios;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicElementInteraction {

	public static void main(String[] args) throws Exception {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		System.out.println("Current url title: "+driver.getTitle());
		//Click 'Element' section
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[2]")).click();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals("https://demoqa.com/elements")) {
			System.out.println("Element page is opened.");
		}
		//Checking visibility of Test box
		boolean boolTextBox = driver.findElement(By.xpath("//span[text()='Check Box']")).isDisplayed();
		System.out.println("Check box is visible: "+boolTextBox);
		if(! boolTextBox == true) {
			System.out.println("Click Check box tab");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]/span")).click();
			driver.findElement(By.xpath("//span[text()='Check Box']")).click();
		}else {
			driver.findElement(By.xpath("//span[text()='Check Box']")).click();
		}
		
		try{
		    if(driver.findElement(By.xpath("//span[text()='Desktop']")).isDisplayed())
		        System.out.println("Element is present and displayed");
		    else
		        System.out.println("Element is present but not displayed"); 
		}catch (Exception e) {
		    System.out.println("Element is not present, hence not displayed as well");
		    driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
		}
		
		String tabs[] = {"Desktop", "Downloads"};
		for(String tab : tabs) {
			WebElement ele = driver.findElement(By.xpath("//span[text()='"+tab+"']"));
			js.executeScript("arguments[0].scrollIntoView();",ele);
			driver.findElement(By.xpath("//span[text()='"+tab+"']")).click();
			System.out.println("Checked "+tab+" tab");
		}
		WebElement result = driver.findElement(By.xpath("//div[@id='result']"));
		js.executeScript("arguments[0].scrollIntoView();",result);
		List<WebElement> resultList = driver.findElements(By.xpath("//div[@id='result']/span"));
		System.out.println(resultList.size()); //7
//		System.out.println(result.getText());
		for(int i=1; i<+resultList.size(); i++) {
			String opResult = driver.findElement(By.xpath("//div[@id='result']/span["+i+"]")).getText();
			System.out.print(opResult+" ");
		}
		System.out.println();
		
		
		
		
		
		
		
		
		
	}

}
