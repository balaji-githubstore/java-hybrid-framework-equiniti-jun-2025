package com.eq.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider
	public Object[][] invalidLoginData()
	{
		Object[][] data=new Object[2][3];
		
		data[0][0]="saul";
		data[0][1]="saul123";
		data[0][2]="Invalid credentials";
		
		data[1][0]="kim";
		data[1][1]="kim123";
		data[1][2]="Invalid credentials";
		
		return data;
	}
	
	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException
	{
		//Testmethod name is the sheetname
		String testMethodName=method.getName();
		Object[][] data= ExcelUtils.getSheetIntoTwoDimensionalArray("test-data/orange-test-data.xlsx", testMethodName);
		return data;
	}
}
