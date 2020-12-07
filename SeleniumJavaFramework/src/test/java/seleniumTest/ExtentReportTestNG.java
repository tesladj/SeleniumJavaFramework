package seleniumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTestNG {
	WebDriver driver = null;
	ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	@BeforeSuite
	public void setUp(){
		 htmlReporter = new ExtentHtmlReporter("extentnew.html");
		 extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        String projectPath = System.getProperty("user.dir");
			System.out.println("projectPath :" + projectPath);
			//System.setProperty("webdriver.gecko.driver",projectPath + "/drivers/geckodriver.exe");
			//WebDriver driver = new FirefoxDriver();
			
			System.setProperty("webdriver.chrome.driver",projectPath + "/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
	}
	@Test
	public void getText() throws IOException{
		 test = extent.createTest("MyFirstTest", "Sample description");
		// log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        test.log(Status.INFO, "Test is started");
		
		driver.get("https://www.motorola.com/u/");
		test.pass("this is passed");
		try{
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		WebElement menu = driver.findElement(By.xpath("//body/div[@id='render-store.home']/div/div/div/div/div/header/div/div/nav/div/ul/li[3]/span[1]"));
		System.out.println(menu.getText());
		test.pass("got text");
        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}
	@AfterSuite
	public void tearDown(){
		driver.quit();
		
		test.pass("Browser closed");
		test.info("test is completed");
		
		extent.flush();
	}
}
