package testScenarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testObjectRepository.HomePage;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelReadWrite;
import userDefinedLibraries.Screenshot;
/**
 * This class is defined in order to implement the given test scenario of E-commerce automation.
 * Separate methods are defined to execute at certain priorities
 * defined by execution flow of different test cases. 
 * 
 * @author JIBIN JOSE
 * @since 2020/11/01
 * 
 */

public class EbayMobilesAutomation extends DriverSetup {

	public static XSSFWorkbook workbook ; 
    public static XSSFSheet sheet;
    public static XSSFCell cell,cellValue;
	public static XSSFRow Row;
    public static String elCategory;
    public static String subCategory;
    public static String subMenuCategory;
    public static String browser;
    public static File src;
    public static int t,Max,count;
    public static List<WebElement> resultList;
    public static WebElement firstElement,secElement,thirdElement,priceElement,highPrice,minCost,maxCost,arrival,newArrivals;
    public static WebDriver driver;
    
    @Parameters("browser")
    @BeforeClass
    public void driverConfig(String browser) {
    	
    	driver=DriverSetup.driverInstantiate(browser);   
    
    }
    
    //Reading excel file
    @Test(priority=1)
    public void testCaseReadExl() {
    	
    	try{
    		
    		ExcelReadWrite.readExcel();    	
    	
    	}catch(FileNotFoundException e) {
    		
    		System.out.println("Excel file not found!!!" + e.toString());
    	
    	}catch(IOException e) {
    		
    		System.out.println("Error in reading Excel file!!!" + e.toString());
    	
    	}
    }
    
    //Selecting electronics category
    @Test(priority=2)
    public static void tcElectronicsCategory() {    		
        
    	try{
        	 
    		firstElement=HomePage.electronicsCategory(driver);     
        	 
    		if(firstElement.getText().equalsIgnoreCase(ExcelReadWrite.categoryElectronics)) {
        		 
        		 firstElement.click();
        	 
        	 }
        }catch(Exception e) {
        	 
        	System.out.println("Can't access Electronics category!" + e.toString());
        
        }      
    }
    
    //Selecting Cell Phones, Smart Watches & Accessories category
    @Test(priority=3)
    public static void tcPhoneAccessoriesCategory() {
    	
    	try{
    		
    		secElement=HomePage.phonesAccessoriesSubcategory(driver);
    		
    		if(secElement.getText().equalsIgnoreCase(ExcelReadWrite.categoryCellphone)){
    			
    			secElement.click();
    		}
    	
    	}catch(Exception e) {
    		
    		System.out.println("Can't access Cell Phones, Smart Watches & Accessories category!" + e.toString());
    	
    	}
    }
    
    //Selecting Cell Phones & Smartphones category
    @Test(priority=4)
    public static void tcMobilesCategory() {
    	
    	try{
    		
    		thirdElement=HomePage.smartphonesSubcategory(driver);
    		
    		if(thirdElement.getText().equalsIgnoreCase(ExcelReadWrite.categorySmartphones)){
    			
    			thirdElement.click();
    		
    		}
    	
    	}catch(Exception e) {
    		
    		System.out.println("Can't access Cell Phones & Smartphones category!" + e.toString());
    	
    	}
    }
    
    //Setting minimum price
    @Test(priority=5)
    public static void minPriceSet() {
    	
    	try{
    		
    		priceElement=HomePage.minPrice(driver);
    		HomePage.minPrice(driver).sendKeys(ExcelReadWrite.miniCost);
    	
    	}catch(Exception e) {
    		
    		System.out.println("Minimum price is not set!" + e.toString());
    	
    	}
    }
    
    //Setting maximum price and submitting the price
    @Test(priority=6)
    public static void maxPriceSet() {
    	
    	try{
    		
    		highPrice=HomePage.maxPrice(driver);
    		highPrice.sendKeys(ExcelReadWrite.maxiPrice);
    		HomePage.priceSubmit(driver).click();
    	
    	}catch(Exception e){
    		
    		System.out.println("Maximum price is not set!" + e.toString());
    		
    	}
    }
    
    //Sort the product results based on new arrivals
    @Test(priority=7)
    public static void sortByTime() {
    	
    	try{
    		
    		Actions act = new Actions(driver);
    		arrival=HomePage.mouseHoverMenu(driver);
    		act.moveToElement(arrival).perform();
    		
    		newArrivals=HomePage.mouseHoverSubmenu(driver);
    		
    		if(newArrivals.getText().equalsIgnoreCase(ExcelReadWrite.newlyArrive)){
    			
    			act.moveToElement(newArrivals).click().perform();
    		}
    	
    	}catch(Exception e) {
    		
    		System.out.println("Some problem occurs while accessing new arrivals!" + e.toString());
    	
    	}
    	
    }
    
    //Writing retrieved product results to excel file
    @Parameters("browser")
    @Test(priority=8)
    public static void toExcelWrite(String browser) {
    	
    	try{
    		
    		String browserType=browser;
    		//Receiving the products list and assign it to the webelement
    		resultList=HomePage.productResults(driver);
    		//Storing the count of mobiles to Max
    		Max=Integer.parseInt(ExcelReadWrite.productCount); 
    		System.out.println("No of Mobiles : " + Max);
    		String[] resultSet=new String[Max];
    		
    		//Storing the mobile details to a string array
    		for(int item=0;item<Max;item++ ) {
    			
    			resultSet[item]=resultList.get(item).getText();
    			
    		}
 		
    			if(browserType.equalsIgnoreCase("chrome")) {
    				
    				//Writing the browser name to excel file
    				cellValue=ExcelReadWrite.sheet.getRow(1).createCell(7);
    				cellValue.setCellValue(browserType.toUpperCase());
    					
    					//Writing outputs to excel file
    					for(int item=2,count=0;item<7 && count<5;item++,count++) {
    						
    						cellValue=ExcelReadWrite.sheet.createRow(item).createCell(7);
    						cellValue.setCellValue(""+resultSet[count]);
    						System.out.println("Writing data to Excel : "+cellValue);
    					}
    					ExcelReadWrite.writeExcel();

    			}else if(browserType.equalsIgnoreCase("opera")){
    				 
    				//Writing the browser name to excel file
    				cell=ExcelReadWrite.sheet.getRow(9).createCell(7);
    				cell.setCellValue(browserType.toUpperCase());
    				 	
    				 	//Writing outputs to excel file
    				 	for(int item=11,count=0;item<16 && count<5;item++,count++) {
    						
    						cellValue=ExcelReadWrite.sheet.createRow(item).createCell(7);
    						cellValue.setCellValue((String)resultSet[count]);
    						System.out.println("Writing data to Excel : "+cellValue);
    					}
    					ExcelReadWrite.writeExcel();
    			}
    	
    	}catch(Exception e) {
    		
    		System.out.println("Error occured while writing data!" + " " + e.toString());
    	
    	}
    }
    
    //Taking screenshots of the webpages
    @Test(priority=9)
    public static void screenShot() {
  	  
    	try{
  		  
    		JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("window.scrollBy(0,170)");
        	Screenshot.screenShotTC(driver);	  
  	  
    	}catch(Exception e) {
  		  
    		System.out.println("Problem in calling screenShot() ! ");
    		e.printStackTrace();
  	  
    	}
    }

    //Calling the driverClose() for closing the browsers
    @AfterClass
    public void driverExit() {
    	
    	try{
    		
    		DriverSetup.driverClose();    
    	
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    	
    	}
    }  
}
