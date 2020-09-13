package com.testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println();
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success".toUpperCase());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Fail".toUpperCase()+result.getName());
	}
	
	@Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

   	
}
