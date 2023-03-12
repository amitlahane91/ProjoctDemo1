package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utility {
	
	public static void captureScreenshot(WebDriver driver , int TestId) throws IOException {
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String dateFormat = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());
		 Date dt = new Date();
		 String date = dateFormat.formatted(dt);
		 File dest = new File("C:\\Users\\lahan\\eclipse-workspace\\Demo1\\Screenshots\\Testid"+ TestId+ date+".jpg");
		 FileHandler.copy(source, dest);
		 
		 
	}

}
