package testObjectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class is defined in order to get the xpath of Webelements.
 * Separate methods are defined to get various webelements
 * 
 * @author JIBIN JOSE
 * @since 2020/11/01
 * 
 */

public class HomePage {
	
	//Creating WebDriver and WebElement
	public static WebElement element;
	public static WebDriver driver;
	
	//To get the xpath of Electronics - Category
	public static WebElement electronicsCategory(WebDriver driver) {
		
		//This waits up to 20 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 20 seconds
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/a")));
		element=driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/a"));
		return element;
	}
	
	//To get the xpath of Smartphones,Watches & Accessories - Category
	public static WebElement phonesAccessoriesSubcategory(WebDriver driver) {
		
		//This waits up to 5 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 5 seconds
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Cell Phones, Smart Watches & Accessories')]")));
		element=driver.findElement(By.xpath("//div[contains(text(),'Cell Phones, Smart Watches & Accessories')]"));
		return element;
	}
	
	//To get the xpath of Cell phones & Smartphones - Category
	public static WebElement smartphonesSubcategory(WebDriver driver) {
		
		//This waits up to 5 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 5 seconds
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='s0-26-9-0-1[0]-0-0-xCarousel-x-carousel-items']/ul/li[2]/a/p")));
		element=driver.findElement(By.xpath("//*[@id='s0-26-9-0-1[0]-0-0-xCarousel-x-carousel-items']/ul/li[2]/a/p"));
		return element;
	}
	
	//To get the xpath of minimum price textbox
	public static WebElement minPrice(WebDriver driver) {
		
		//This waits up to 20 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 20 seconds
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='s0-29-13_2-0-1[1]-0-6-0-3[2]-textrange']/div/div[1]/div/input")));
		element=driver.findElement(By.xpath("//*[@id='s0-29-13_2-0-1[1]-0-6-0-3[2]-textrange']/div/div[1]/div/input"));
		System.out.println(element.getText());
		return element;
	}
	
	//To get the xpath of maximum price textbox
	public static WebElement maxPrice(WebDriver driver) {
		
		//This waits up to 10 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 10 seconds
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='s0-29-13_2-0-1[1]-0-6-0-3[2]-textrange']/div/div[2]/div/input")));
		element=driver.findElement(By.xpath("//*[@id='s0-29-13_2-0-1[1]-0-6-0-3[2]-textrange']/div/div[2]/div/input"));
		System.out.println(element.getText());
		return element;
	}
	
	//To get the xpath of submit button
	public static WebElement priceSubmit(WebDriver driver) {
		
		//This waits up to 10 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 10 seconds
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='s0-29-13_2-0-1[1]-0-6-0-3[2]-textrange']/div/button")));
		element=driver.findElement(By.xpath("//*[@id='s0-29-13_2-0-1[1]-0-6-0-3[2]-textrange']/div/button"));
		return element;
	}
	
	//To get the xpath of list of sorting menu
	public static WebElement mouseHoverMenu(WebDriver driver) {
		
		//This waits up to 10 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 10 seconds
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(text(),'Best Match')]")));
		element=driver.findElement(By.xpath(".//div[contains(text(),'Best Match')]"));
		return element;
	}
	
	//To get the xpath of newly arrived items from sorting list
	public static WebElement mouseHoverSubmenu(WebDriver driver) {
		
		//This waits up to 10 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 10 seconds
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[contains(text(),'Time: newly listed')]")));
		element=driver.findElement(By.xpath(".//span[contains(text(),'Time: newly listed')]"));
		return element;
	}
	
	//To get the list of mobiles
	public static List<WebElement> productResults(WebDriver driver) {
		
		//This waits up to 10 seconds before throwing a TimeoutException or if it finds the element visibility will return it in 0 - 10 seconds
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='s0-26-9-0-1[0]-0-1']/ul/li")));
		List<WebElement> productList=driver.findElements(By.xpath("//*[@id='s0-26-9-0-1[0]-0-1']/ul/li"));
		return productList;
	}
	
}
