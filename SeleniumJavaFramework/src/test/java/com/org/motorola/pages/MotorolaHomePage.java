package com.org.motorola.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Org.Motorola.Config.Config;

public class MotorolaHomePage {

	//public MotorolaHomePage(){}
	static WebDriver driver;
	public MotorolaHomePage(WebDriver driver) {
		 this.driver=driver;
		 }
	
//	public MotorolaHomePage(WebDriver driver){
//		PageFactory.initElements(Config.driver, this);
//	}
	@FindBy(how=How.XPATH,using="//div[@class='logo']")
	public WebElement logo;
	
//	@FindBy(how=How.XPATH,using="//span[@class='vtex-login-2-x-label t-action--small pl4 gray dn db-l']")
//	public WebElement signIn;
	
	By closeCookie = By.xpath("//*[@class='close-icon show']");
	
	public void closeCookie(){
		Config.driver.findElement(closeCookie).click();
	}
	
	 By razr = By.xpath("//li[@class='dropdown-open']//div[@class='dropdown-box']//div[@class='container']//div[@class='dropdown-container']//div[@class='dropdown-inner']//ul//li//figcaption[contains(text(),'Razr')]");
	public void razrClick(){
		Config.driver.findElement(razr).click();
	}
	
	 By phones = By.xpath("//span[@class='navbar-item'][normalize-space()='Phones']");
	 
	 public void phoneHover(){
		 Actions action = new Actions(Config.driver);
		 WebElement we = Config.driver.findElement(phones);
		 action.moveToElement(we);
		 
		 try {
			Thread.sleep(6000);
			action.build().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	 }
	 
	 
	By signIn = By.xpath("//span[@class='vtex-login-2-x-label t-action--small pl4 gray dn db-l']");
	
	By accessCodeLogin = By.xpath("//span[normalize-space()='Receive access code by e-mail']");
	
	public void accessCodeLogin(){
		Config.driver.findElement(accessCodeLogin).click();
	}
	public void signIn(){
		Config.driver.findElement(signIn).click();
	}
	
	public void checkLogo(){
		logo.click();
	}
	public String getLogo(){
		String logotext = logo.getText();
		return logotext;
	}
	
	
}
