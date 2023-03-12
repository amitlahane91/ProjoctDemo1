package TestDemo1;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Base.Browsers;
import POMDemo.LoginPage;
import Utils.utility;

public class TestLoginPage extends Browsers {
	
	WebDriver driver;
	LoginPage log;
	int TestId;
	
	
	@BeforeClass
	public void launchbrowser() {
		driver=openChromebrowser();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void createobjects() {
		log = new LoginPage(driver);
	}
	
	@Test
	public void testloginfunction() throws InterruptedException {
		TestId=84;
		log.enteremail();
		log.enterpassword();
		log.loginbtn();
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Dashboard / nopCommerce administration";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			utility.captureScreenshot(driver, TestId);
		}
		log.logoutbtn();
		log=null;
	}
	@AfterClass
	public void closebrowser() {
		driver.quit();
	}

}
