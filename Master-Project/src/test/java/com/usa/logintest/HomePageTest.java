package com.usa.logintest;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.usa.basepage.SupperClass;
import com.usa.pagefactory.HomePage;
import com.usa.pagefactory.LoginPage;
import com.usa.utility.SeleniumUtil;

public class HomePageTest extends SupperClass {
	final String name = "London";
	HomePage hp;
	LoginPage lP;

	@BeforeMethod
	public void setUp() {
		initialization();
		hp = new HomePage();
		lP = new LoginPage();
		lP.login(prop.getProperty("userName"), prop.getProperty("textPassword"));
	}

	@Test
	public void propertyValidation() throws InterruptedException {
		hp.getEnterTheText().sendKeys(name);
		hp.getEnterTheText().sendKeys(Keys.ENTER);
			
		SeleniumUtil.getExplicitWait(hp.FindTotalHouse(), driver);
		
		SeleniumUtil.getExplicitWait(hp.FindFifthProperty(), driver);
		
		SeleniumUtil.getExplicitWait(hp.getVerifyHousePrice(), driver);

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
