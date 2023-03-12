package TestDemo1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Base.Browsers;
import POMDemo.AddNewCostumer;
import POMDemo.LoginPage;
import Utils.utility;

public class TestAddNewCostumer extends Browsers {
	WebDriver driver;
	int TestId;
	LoginPage log;
	AddNewCostumer cstmer;
	
	@BeforeTest
	public void launchbrowser() {
		driver=openChromebrowser();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createobjects() {
		log = new LoginPage(driver);
		cstmer = new AddNewCostumer(driver);
	}
	
	@BeforeMethod
	public void login() throws InterruptedException {
		log.enteremail();
		log.enterpassword();
		log.loginbtn();
	}
	
	@Test
	public void testAddNewCostumer() throws InterruptedException {
		cstmer.clickoncostumers();
		cstmer.clickoncostumer();
		cstmer.clickonAddnew();
		cstmer.addemailid();
		cstmer.addpaswrd();
		cstmer.addfirstnamefield();
		cstmer.addlastnamefield();
		cstmer.selectgendertype();
		boolean male = cstmer.selectgender.isSelected();
		Assert.assertEquals(male, true);
		cstmer.addDOBfield();
		cstmer.addcompanynamefield();
		cstmer.selectcostumerrole();
		cstmer.clickonsave();
		String actual = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		String expected = "The new customer has been added successfully.";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			utility.captureScreenshot(driver, TestId);
		}
		log.logoutbtn();
	}
	
	@AfterClass
	public void clrearobjects() {
		log=null;
		cstmer=null;
	}
	
	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

}
