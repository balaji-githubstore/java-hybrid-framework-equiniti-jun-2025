package com.eq.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ZDemo4Prop {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties prop=new Properties();
		prop.load(new FileInputStream("src/test/resources/config/data.properties"));
		System.out.println(prop);
		
		System.out.println(prop.getProperty("browser1"));
		System.out.println(prop.getProperty("url"));
	}

}
