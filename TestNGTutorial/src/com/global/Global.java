package com.global;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Global {

	public static void main(String[] args) throws IOException {
		String dir=System.getProperty("user.dir");
		
		Properties prop=new Properties();
		InputStream file=new FileInputStream(dir+"/Prop.properties");
		prop.load(file);
		String name=prop.getProperty("name");
		System.out.println(name);
		prop.setProperty("name", "suraj");
		System.out.println(prop.getProperty("name"));
		FileOutputStream fout=new FileOutputStream(dir+"/Prop.properties");
		prop.store(fout, null);
	}

}
