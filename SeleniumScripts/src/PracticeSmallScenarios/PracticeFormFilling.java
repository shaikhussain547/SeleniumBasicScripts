package PracticeSmallScenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormFilling {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/forms");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Implicit wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Current url title: "+driver.getTitle());
		//Checking visibility of 'Practice Form'
		WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
		boolean boolPracticeForm = practiceForm.isDisplayed();
		if(!boolPracticeForm == true) {
			driver.findElement(By.xpath("//*[text()='Forms']/span")).click();
			practiceForm.click();
		}else {
			practiceForm.click();
		}
		//If 'Student registration form' opened
		WebElement stdRegForm = driver.findElement(By.xpath("//div[@class='practice-form-wrapper']/h5"));
		if(stdRegForm.isDisplayed()) {
			System.out.println(stdRegForm.getText()+"  opened.");
		}
		//Filling form
/*		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Wick");
		js.executeScript("window.scrollBy(0, 200);");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("johnwick@gmail.com");
		js.executeScript("window.scrollBy(0, 200);");
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		js.executeScript("window.scrollBy(0, 200);");
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("9876543210");
		js.executeScript("window.scrollBy(0, 200);");

		//Date of Birth
		WebElement jDate = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		js.executeScript("arguments[0].scrollIntoView();",jDate);
		jDate.click();
		sleep();
		String date = "20";
		String month = "February";
		Select seYear = new Select(driver.findElement(By.xpath("//div[contains(@class,'year-dropdown')]/select")));
		seYear.selectByValue("1999");
		sleep();
		Select seMonth = new Select(driver.findElement(By.xpath("//div[contains(@class,'month-dropdown')]/select")));
		seMonth.selectByVisibleText(month);
		sleep();
		List<WebElement> calendar = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[contains(@aria-label,'"+month+"')]"));
		System.out.println(calendar.size());
		js.executeScript("arguments[0].scrollIntoView();",jDate);
		for(int i=0; i <= calendar.size(); i++) {
			System.out.println(calendar.get(i).getText());
			if(calendar.get(i).getText().equals(date)) {
				calendar.get(i).click();
				break;
			}
		}
*/		
		//Subjects
		WebElement subject = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__input']/input"));
		js.executeScript("arguments[0].scrollIntoView();", subject);
		sleep();
		subject.click();
//		subject.sendKeys("Maths");
		String sub[] = {"Maths", "Physics"};
		for(String eachSub : sub) {
			subject.sendKeys(eachSub);
			WebElement sub_dropdown = driver.findElement(By.xpath("//div[contains(@class,'subjects-auto-complete__menu')]"));
			js.executeScript("arguments[0].scrollIntoView();", subject);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'subjects-auto-complete__menu-')]/div")));
			if(sub_dropdown.getText().equals(eachSub)) {
				System.out.println(sub_dropdown.getText());
				sub_dropdown.click();
			}
		}

		System.out.println("Completed");
		
		
		
		
	}

	public static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
