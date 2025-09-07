package com.qa.opencart.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.opencart.factory.DriverFactory;

public class ReportUtils {
	
	/**
	 * This method is used to take the screenshot
	 * 
	 * @return srcFile
	 */

	public static File takeScreenshot() {
		System.out.println("Taking Screenshot....");
		File srcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		return srcFile;

	}
	
	/**
	 * This method is used to take the screenshot in bytes
	 * 
	 * @return byte[]
	 */
	public static byte[] takeScreenshotAsBytes() {
		System.out.println("Taking Screenshot in bytes....");
		return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
		
		}
	
	/**
	 * This method is used to take the screenshot in Base64
	 * @return String
	 */
	
	public static String takeScreenshotAsBase64() {
		System.out.println("Taking Screenshot in Base64....");
		return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BASE64);
		
		}
	
	

}
