package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	
	
	public static WebDriver openChromebrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	     return driver;
	}
	public static WebDriver openFirefoxbrowser() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
