package com.usa.logintest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.usa.basepage.SupperClass;
import com.usa.pagefactory.LoginPage;

public class LoginTest extends SupperClass {

	LoginPage lP;

	@BeforeMethod
	public void setUp() {
		logger.info("******** As a user i can open the browser *********");
		initialization();
		lP = new LoginPage();
	}

	@Test
	public void loginPageTitleTest() {
		try {
			logger.info("******** As a user i can login to the application *********");
			lP.login(prop.getProperty("userName"), prop.getProperty("textPassword"));
			logger.info("******** As a user i can verify page title *********");
			String title = lP.validateLoginPageTitle();
			Assert.assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
			System.out.println(" Home page title :: Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
