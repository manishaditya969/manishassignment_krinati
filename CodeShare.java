package com.finalsubmission.kiriti;




import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CodeShare {
	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "G:\\seedinfotech\\\\New folder\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://codeshare.io/");
		driver.manage().window().maximize();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		
		driver.findElement(By.xpath("//*[@id=\"home\"]/section[1]/div/div[1]/p[1]/a")).click();
		driver.findElement(By.xpath("//textarea[@spellcheck='false']")).sendKeys("#include <stdio.h>");
		String newaddress = driver.getCurrentUrl();
		
		 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		ChromeDriver driver1 = new ChromeDriver(options);		
		driver1.get(newaddress);
		Thread.sleep(5000);
		
		driver1.manage().window().maximize();
		
		driver1.findElement(By.xpath("//textarea[@spellcheck='false']")).sendKeys(" #include <conio.h> \n");
		
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);
		Iterator<String> I1= allWindowHandles.iterator();
		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());
		

		
	}
		}
		driver.switchTo().window(parent);
	}
		
	
}


