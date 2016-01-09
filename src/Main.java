import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;

public class Main {

	public static void main (String[] args){
		//Launch driver
		WebDriver driver = new FirefoxDriver();
		//Navigate to URL
		driver.navigate().to("http://www.allswim.co.uk");
		//Enter text in Search field
		driver.findElement(By.id("small-searchterms")).sendKeys("inflatable");
		//Click Search button
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		//Add first item in search results to cart
		driver.findElement(By.xpath("//input[@value='Add To Cart']")).click();
		//Click on shopping cart link
		try
		{
			driver.findElement(By.linkText("shopping cart")).click();
		}
		catch (Exception ignore)
		{
			driver.findElement(By.id("topcartlink")).click();;
		}
		
		//Check you've arrived at the shopping cart page
		Assert.assertTrue("Failed to arrive at Shopping Cart page", driver.getTitle().equals("Shopping Cart"));
		//Check that item is in the results table
		Assert.assertNotNull(driver.findElement(By.xpath("//table//*[text()[contains(.,'Extreme Rings')]]")));
		//Close browser
		driver.quit();
		
	}
	
}
