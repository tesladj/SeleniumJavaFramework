package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		 ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	        String projectPath = System.getProperty("user.dir");
			System.out.println("projectPath :" + projectPath);
			
			System.setProperty("webdriver.chrome.driver",projectPath + "/chromedriver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
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
			
			driver.quit();
			
			test.pass("Browser closed");
			test.info("test is completed");
			
			extent.flush();
			
			
	}

}
 