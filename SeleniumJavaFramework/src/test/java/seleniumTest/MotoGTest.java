package seleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.org.motorola.pages.MotorolaHomePage;
import com.org.motorola.pages.MotorolaMotoGPage;
import com.org.motorola.pages.ViewCartPage;

import Org.Motorola.Config.Config;

//@Listeners(TestNGListner.TestNGtest.class)
public class MotoGTest {

	public static int timeout =30;
	MotorolaHomePage mp = new MotorolaHomePage(Config.driver);
	MotorolaMotoGPage mg = new MotorolaMotoGPage(Config.driver);
	ViewCartPage vp = new ViewCartPage(Config.driver);
	
	@BeforeTest
	public void setUpTest(){
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath :" + projectPath);
		//System.setProperty("webdriver.gecko.driver",projectPath + "/drivers/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver",projectPath + "/chromedriver/chromedriver.exe");
		Config.driver = new ChromeDriver();
	}
	//Test
	@Test(priority = 1)
	public void motoG(){
		Config.driver.get("https://www.motorola.com/us/");
		Config.driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		Config.driver.manage().window().maximize();
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		//mp.signIn();
		//Config.driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		mp.closeCookie();
		mp.phoneHover();
		mg.motoGClick();
		mg.motoGPowerHover();
		mg.learnMoreClick();
		mg.addToCart();
		mg.viewCart();
				
	}
	
	@Test (priority = 2)
	public void viewCartPage(){
		vp.learnMoreClick();
		vp.selectGoodWarranty();
	}
	@AfterTest
	public void tearDown(){
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		Config.driver.quit();
	}
}


