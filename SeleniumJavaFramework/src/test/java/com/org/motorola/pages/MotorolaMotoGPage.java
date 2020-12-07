package com.org.motorola.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.org.motorola.pagebase.MotorolaHomePageBase;

import Org.Motorola.Config.Config;

public class MotorolaMotoGPage extends MotorolaHomePageBase{

	public MotorolaMotoGPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		Config.driver=driver;
	}
	By addCart = By.xpath("//span[@class='vtex-store-components-3-x-buyButtonText']");
	
	public void addToCart(){
		Config.driver.findElement(addCart).click();
	}
	By viewCart = By.xpath("//div[contains(text(),'View cart')]");
	
	public void viewCart(){
		Config.driver.findElement(viewCart).click();
	}
	
	By motog= By.xpath("//li[@class='dropdown-open']//div[@class='dropdown-box']//div[@class='container']//div[@class='dropdown-container']//div[@class='dropdown-inner']//ul//li//figcaption[contains(text(),'Moto G')]");

	By motogHov = By.xpath("//a[@href='/us/smartphones-moto-g-power/p']//img");
	
	By learnMore = By.xpath("//a[@href='/us/smartphones-moto-g-power/p'][normalize-space()='Learn More']");
	public void motoGClick(){
		Config.driver.findElement(motog).click();
	}
	
	public void motoGPowerHover(){
		Actions action = new Actions(Config.driver);
		WebElement we = Config.driver.findElement(motogHov);
		 action.moveToElement(we);
		 
		 try {
			Thread.sleep(6000);
			action.build().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void learnMoreClick(){
		Config.driver.findElement(learnMore).click();
	}
}
