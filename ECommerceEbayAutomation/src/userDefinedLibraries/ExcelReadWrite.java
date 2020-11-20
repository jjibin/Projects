package userDefinedLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * This class is defined in order to implement reading from and writing to excel file.
 * 
 * 
 * @author JIBIN JOSE
 * @since 2020/11/01
 * 
 */

public class ExcelReadWrite {
	
	public static File src;
	public static String excelfilepath = "C:\\Users\\JIBIN JOSE\\workspace\\ECommerceEbayAutomation\\src\\dataTables\\Database.xlsx";
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook; 
	public static XSSFSheet sheet;
	public static String val1;
	public static int row;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static String categoryElectronics;
    public static String categoryCellphone;
    public static String categorySmartphones;
    public static String miniCost;
    public static String maxiPrice;
    public static String newlyArrive;
    public static String productCount;
    public static int minimumPrice,maximumPrice,noOfProducts;
    
    public static int readExcel() throws IOException {
		
    	//Reading inputs from excel file
    	try
	    {
    		//Create an object of File class to open xlsx file
    		
    		src=new File(excelfilepath);
    		
    		//Create an object of FileInputStream class to read excel file
    		
    		fileip = new FileInputStream(src);
		    
    		 //Create an object of XSSFWorkbook class
    		
    		workbook = new XSSFWorkbook(fileip); 
		    
    		//Read sheet inside the workbook by its index
    		
    		sheet = workbook.getSheetAt(0);
		    
    		 //Create a loop until the last row of excel file to read it
    		
    		for(int i=1; i<=sheet.getLastRowNum(); i++) {
	            if(i==1) {
	                 categoryElectronics = (sheet.getRow(i).getCell(0)).getStringCellValue();
	                 categoryCellphone = (sheet.getRow(i).getCell(1)).getStringCellValue();
	                 categorySmartphones= (sheet.getRow(i).getCell(2)).getStringCellValue();
	                 minimumPrice= (int)(sheet.getRow(i).getCell(3)).getNumericCellValue();
	                 miniCost=String.valueOf(minimumPrice);
	                 maximumPrice=(int)(sheet.getRow(i).getCell(4)).getNumericCellValue();
	                 maxiPrice=String.valueOf(maximumPrice);
	                 newlyArrive=(sheet.getRow(i).getCell(5)).getStringCellValue();
	                 noOfProducts=(int)(sheet.getRow(1).getCell(6)).getNumericCellValue();
	                 productCount=String.valueOf(noOfProducts);
	                 
	              	 //Print Excel data in console
	                 System.out.println(categoryElectronics);
	                 System.out.println(categoryCellphone);
	                 System.out.println(categorySmartphones);
	                 System.out.println(miniCost);
	                 System.out.println(maxiPrice);
	                 System.out.println(newlyArrive);
	                 System.out.println(productCount);
	                 row=i;	                 
	                 break;
	            }
	        }	    	
	    }catch (FileNotFoundException e) {
	    		
	    	e.printStackTrace();
	    	
        }catch (IOException e) {
        	
        	e.printStackTrace();
        	
		}
		return row;
	}
	
	public static void writeExcel() {		
	  try
	  { 		  
		//Close input stream
	      fileip.close();
	    //Create an object of FileOutputStream class to create write data in excel file
	      fileop =new FileOutputStream(new File(excelfilepath));
	    //write data in the excel file
	      workbook.write(fileop);
	    //close output stream
	      fileop.close();	   	         
	  } catch (FileNotFoundException e) {
	         
		  e.printStackTrace();
	  
	  } catch (IOException e) {
	         
		  e.printStackTrace();
	  
	  }
	
	}	

}
