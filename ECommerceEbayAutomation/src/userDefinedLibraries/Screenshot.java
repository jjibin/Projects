package userDefinedLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * This class is defined in order to take screenshot of webpages.
 * 
 * @author JIBIN JOSE
 * @since 2020/11/01
 * 
 */

public class Screenshot {
	
	public static void screenShotTC(WebDriver ldriver) {
		
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);       
		
		try
		{  
			// now copy the  screenshot to desired location using copyFile method
			FileUtils.copyFile(src, new File("C:\\Users\\JIBIN JOSE\\workspace\\ECommerceEbayAutomation\\TCScreenshots\\"+System.currentTimeMillis()+".png"));
       
		}catch (IOException e) {
        	
        		System.out.println(e.getMessage());      
		}
		
	  }

}
