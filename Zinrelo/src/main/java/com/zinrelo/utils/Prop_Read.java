package com.zinrelo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Prop_Read {
	File file;
	FileInputStream fileInput;
	Properties prop;
	static String dir,uri,userId,passWord;
	
	public static String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
	public static void setUri(String uri) {
		Prop_Read.uri = uri;
	}

	public static void setUserId(String userId) {
		Prop_Read.userId = userId;
	}

	public static void setPassWord(String passWord) {
		Prop_Read.passWord = passWord;
	}

	public static String getUri() {
		return uri;
	}

	public static String getUserId() {
		return userId;
	}

	public static String getPassWord() {
		return passWord;
	}

	public Prop_Read() throws IOException {
		dir=System.getProperty("user.dir");
		file = new File(dir+"/src/test/resources/Properties/Config.properties");
		fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);
		uri= prop.getProperty("uri");
		userId= prop.getProperty("user_id");
		passWord= prop.getProperty("password");
		
	}


}
