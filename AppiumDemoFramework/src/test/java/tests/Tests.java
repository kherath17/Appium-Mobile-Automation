package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class Tests extends BaseClass{
	
	@Test
	public void test1() {
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		String title =driver.getTitle();
		String expected = "Automation - Google Search";
		assertEquals(title, expected);
		
		System.out.println("Test one Completed ");
	}
	
	

}
