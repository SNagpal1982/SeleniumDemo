package com.craftsvilla.generic;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CaptureScreenShot implements ITestListener
{
	
	public void onTestFailed(ITestResult result)
	{
		try 
		{
			String methodName = result.getMethod().getMethodName();
			EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
			File src = event.getScreenshotAs(OutputType.FILE);
			File dest = new File(".//ScreenShot//" + methodName + ".png");
		    FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) 
		{
			
		}
	}

}
