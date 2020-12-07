package seleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserTest21 {

	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest(){
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath :" + projectPath);
		//System.setProperty("webdriver.gecko.driver",projectPath + "/drivers/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver",projectPath + "/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void getText1(){
		driver.manage().window().maximize();
		driver.get("https://www.motorola.com/us/");
		try{
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		WebElement menu = driver.findElement(By.xpath("//body/div[@id='render-store.home']/div/div/div/div/div/header/div/div/nav/div/ul/li[3]/span[1]"));
		System.out.println(menu.getText());
		
	}
	
	@AfterTest
	public void tear_Down(){
		driver.quit(); 
	}
		
	}

