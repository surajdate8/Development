package com.zinrelo.pages;

public class Index_Page {
	
	static String ZinreloText ,MembersButton;
	
	public static String getZinreloText() {
		return "//a[@id='store_center']";
	}

	public static void setZinreloText(String zinreloText) {
		ZinreloText = zinreloText;
	}

	public static String getMembersButton() {
		return "//a[@id='customers_tab']";
	}

	public static void setMembersButton(String membersButton) {
		MembersButton = membersButton;
	}

}
