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
	static String dir,uri,userId,passWord,indexPageUrl,membersTab;
	static String email,firstName,lastName,id;
	
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Prop_Read.email = email;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		Prop_Read.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		Prop_Read.lastName = lastName;
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		Prop_Read.id = id;
	}

	public static String getmembersTab() {
		return membersTab;
	}

	public void setmembersTab(String membersTab) {
		Prop_Read.membersTab = membersTab;
	}
	
	public static String getindexPageUrl() {
		return indexPageUrl;
	}

	public void setindexPageUrl(String indexPageUrl) {
		Prop_Read.indexPageUrl = indexPageUrl;
	}
	
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
		file = new File(dir+"/src/main/resources/Properties/Config.properties");
		fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);
		uri= prop.getProperty("uri");
		userId= prop.getProperty("user_id");
		passWord= prop.getProperty("password");
		membersTab=prop.getProperty("membersTab");
		indexPageUrl=prop.getProperty("indexPageUrl");
		email=prop.getProperty("email");
		firstName=prop.getProperty("firstName");
		lastName=prop.getProperty("lastName");
		id=prop.getProperty("id");
	}
}
