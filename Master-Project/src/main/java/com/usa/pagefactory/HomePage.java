package com.usa.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.usa.basepage.SupperClass;

public class HomePage extends SupperClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='dp-sticky-element']/descendant::p[1]")
	@CacheLookup
	private WebElement VerifyHousePrice;
	
	public WebElement getVerifyHousePrice() {
		return VerifyHousePrice;
	}
	
	
	@FindBy(name = "q")
	@CacheLookup
	private WebElement enterText;

	public WebElement getEnterTheText() {
		return enterText;

	}
	

	private WebElement FindTotalHouse;

	public WebElement FindTotalHouse() {
		List<WebElement> list = driver.findElements(
				By.xpath("//*[@class='listing-results-price text-price']"));
		System.out.println("Total number of suggestions in Search Property:::===> " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		return FindTotalHouse;
	}

	private WebElement FindFifthProperty;

	public WebElement FindFifthProperty() {
		Actions builder = new Actions(driver);
		List<WebElement> fifth = driver
				.findElements(By.xpath("//*[@class='listing-results-price text-price']"));
		for (int k = 0; k < fifth.size(); k++) {
			if (k > 4) {
				System.out
						.println("selected " + k + " Number Property and price ::" + fifth.get(k).getAttribute("text"));
				WebDriverWait wait = new WebDriverWait(driver, 10);
				WebElement link = wait.until(ExpectedConditions.elementToBeClickable(fifth.get(k)));					
				if (link != null) {
					System.out.println(link.getText());
					builder.moveToElement(link);
					builder.clickAndHold(link).click().perform(); 
				}
				break;
			}
			}
		
		return FindFifthProperty;
	}
}
