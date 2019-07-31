package seleniumObjectMap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuestionTwo {

	public static void main(String[] args) throws InterruptedException {

		// Setting Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Configurator\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Opening Application URL
		driver.get("https://www.hostelworld.com/");
		
		//Mazimizing the Window
		driver.manage().window().maximize();

		// Entering the city Name
		driver.findElement(By.id("home-search-keywords")).sendKeys("Dublin");
		 Thread.sleep(2000);
		 //selecting the value from dropdown
		driver.findElement(By.id("home-search-keywords")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//clicking on the lets Go button
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[8]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/form[1]/div[2]/button[1]")).submit();
		//Verfying user is on Propeties list Page or not
		Thread.sleep(2000);
		//verifying user is on the correct page or not
		String ExpectedString="FEATURED PROPERTIES";
	    String ActualStrig=driver.findElement(By.xpath("//span[@class='featureheading']")).getText();
	
	    System.out.println("OutPut--->"+ActualStrig);
	     if(ExpectedString.equalsIgnoreCase(ActualStrig))
	     {
	    	 System.out.println("User redirected to the correct Page");
	     }
	
	}
}
