package com.org.motorola.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Org.Motorola.Config.Config;

public class ViewCartPage {

	public ViewCartPage(WebDriver driver){
		Config.driver = driver;
	}
	
	By learnMore = By.xpath("//div[@class='flex flex-grow-1 w-100 flex-column']//a[1]");
	
	public void learnMoreClick(){
		Config.driver.findElement(learnMore).click();
	}
	
	By selectGoodWarranty = By.xpath("//div[contains(@class,'warranty-page-product')]//div[1]//div[1]//div[4]//label[1]//span[1]");
	
	public void selectGoodWarranty(){
		Config.driver.findElement(selectGoodWarranty).click();
	}
}
