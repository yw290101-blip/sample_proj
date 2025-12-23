package sample.proj;

import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.BlockSetTransformer.setAlt_return;

public class WebAppTest {
	
	private static String url ="https://www.amazon.com/";
	
	EdgeDriver driver = new EdgeDriver();
	
	@BeforeTest
	public void LaunchBrowser() {
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Test
	public void verifycolor() throws Throwable {
		Thread.sleep(3000);
		WebElement searchOpt=driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
		String rgbacolorvalue=searchOpt.getCssValue("color");
		System.out.println("Color: "+rgbacolorvalue);
		System.out.println("Location: "+searchOpt.getLocation());
		//String hexcolor = Color.fromString(rgbacolorvalue).asHex();
		
		
		//#c10015
		
	}
	
	@Test
	public void windowns() throws Throwable {
		WebElement signUpopt=driver.findElement(By.xpath("//div[@class=\"nav-line-1-container\"]"));
		Thread.sleep(2000);
		signUpopt.click();
		Thread.sleep(2000);
		WebElement helpopt=driver.findElement(By.xpath("//a[contains(text(),\"Help\")]"));
		helpopt.click();
		String parentWindow=driver.getWindowHandle();
		Set<String>allwindows=driver.getWindowHandles();
		ArrayList<String>allwin = new ArrayList<>(allwindows);
		Thread.sleep(2000);
		for (String win : allwin) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
			} else {
                System.out.println("Not switched to child window");
			}
		}
		//driver.switchTo().window(allwin.get(1));
		WebElement accessibilityOpt=driver.findElement(By.xpath("//div[text()=\"Accessibility\"]"));
		if (accessibilityOpt.isDisplayed()) {
			System.out.println("Accessibility is present");
			File scr = accessibilityOpt.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr,new File("C:/Users/yoges/Downloads/amazon.png"));
		} else {
			System.out.println("Accessibility is not present");
		}
		
	}
	@AfterTest
	public void LogOut() {
		
	}
}
