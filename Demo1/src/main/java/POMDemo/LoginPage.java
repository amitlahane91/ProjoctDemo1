package POMDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import okio.Timeout;

public class LoginPage {
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement logout;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enteremail() throws InterruptedException {
		email.clear();
		Thread.sleep(2000);
		email.sendKeys("admin@yourstore.com");
	}
	public void enterpassword() throws InterruptedException {
		password.clear();
		Thread.sleep(2000);
		password.sendKeys("admin");
	}
	public void loginbtn() {
		login.click();
	}
	public void logoutbtn() {
		logout.click();
	}
	

}
