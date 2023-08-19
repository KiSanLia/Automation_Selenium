package com.atomation.pages;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {
	
	//switch to window by Title
	public static void switchToWindowTitle(String title,WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title)) {
				driver.manage().window().maximize();
				break;
			}
		}
	}
	
	//switch to Parent Window
	public static void switchToPArentWindow(String parentwindow,WebDriver driver) {
		driver.switchTo().window(parentwindow);
	}
	
	public static void fluentwait(WebDriver driver) {
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
		fwait.withTimeout(Duration.ofSeconds(500))
		.pollingEvery(Duration.ofSeconds(10))
		.ignoring(Exception.class);
	}

}
