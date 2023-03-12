package POMDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCostumer {
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement costumers;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	private WebElement costumer;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement Addnew;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement addemail;
	@FindBy(xpath="//input[@id='Password']")
	private WebElement addpassword;
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement addfirstname;
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement addlastname;
	@FindBy(xpath="//input[@id='Gender_Male']")
	public WebElement selectgender;
	@FindBy(xpath="//input[@id='DateOfBirth']")
	private WebElement addDOB;
	@FindBy(xpath="//input[@id='Company']")
	private WebElement addcompanyname;
	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover k-state-focused k-state-border-down']//div[@role='listbox']")
	private WebElement addcostumerrole;
	@FindBy(xpath="//button[@name='save']//i[@class='far fa-save']")
	private WebElement save;
	
	public AddNewCostumer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncostumers() {
		costumers.click();
	}
	public void clickoncostumer() {
		costumer.click();
	}
	public void clickonAddnew() {
		Addnew.click();
	}
	public void addemailid() {
		addemail.sendKeys("abcd12@gmail.com");
	}
	public void addpaswrd() {
		addpassword.sendKeys("abcd12");
	}
	public void addfirstnamefield() {
		addfirstname.sendKeys("amit");
	}
	public void addlastnamefield() {
		addlastname.sendKeys("lahane");
	}
	public void selectgendertype() {
		selectgender.click();
		//selectgender.isSelected();
	}
	public void addDOBfield() {
		addDOB.sendKeys("1/15/2023");
	}
	public void addcompanynamefield() {
		addcompanyname.sendKeys("ajitelectricals");
	}
	public void selectcostumerrole() throws InterruptedException {
		Select slt = new Select(addcostumerrole);
		addcostumerrole.clear();
		Thread.sleep(2000);
		slt.selectByVisibleText("Guests");
		
	}
	public void clickonsave() {
		save.click();
	}

}
