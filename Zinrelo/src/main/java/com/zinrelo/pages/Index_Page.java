package com.zinrelo.pages;

public class Index_Page {
	
	static String ZinreloText ,MembersButton;
	
	public static String getZinreloText() {
		return ZinreloText;
	}

	public static void setZinreloText(String zinreloText) {
		ZinreloText = zinreloText;
	}

	public static String getMembersButton() {
		return MembersButton;
	}

	public static void setMembersButton(String membersButton) {
		MembersButton = membersButton;
	}

	public Index_Page() {
		ZinreloText ="//a[@id='store_center']";
		MembersButton="//a[@id='customers_tab']";
	}
}
