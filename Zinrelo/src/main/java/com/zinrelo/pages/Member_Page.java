package com.zinrelo.pages;

public class Member_Page {
	
	public static String add_new_member,addMemberTabframe;
	public static String frameEmail,frameFirstName,frameLastName,frameID,frameAddButton;
	public static String nestedFrameId,nestedFrameOk,nestedFrameAlertMsg;
	public static String addedName,addedEmail;
	public static String closeButton;
	
	public static String getcloseButton() {
		return "//button[@id='modal_close']";
	}

	public static void closeButton(String closeButton) {
		Member_Page.closeButton = closeButton;
	}

	public static String getAddedName() {
		return "//div[@id='customer_list'] /div/table/tbody/tr[1]/td[2]/a";
	}

	public static void setAddedName(String addedName) {
		Member_Page.addedName = addedName;
	}

	public static String getAddedEmail() {
		return "//div[@id='customer_list'] /div/table/tbody/tr[1]/td[2]/span";
	}

	public static void setAddedEmail(String addedEmail) {
		Member_Page.addedEmail = addedEmail;
	}

	public static String getnestedFrameAlertMsg() {
		return "//div[@id='enroll_alert_box']/span";
	}

	public static void setnestedFrameAlertMsg(String nestedFrameAlertMsg) {
		Member_Page.nestedFrameAlertMsg = nestedFrameAlertMsg;
	}
	
	public static String getnestedFrameOk() {
		return "//a[@id='enroll_user_success']";
	}

	public static void setnestedFrameOk(String nestedFrameOk) {
		Member_Page.nestedFrameOk = nestedFrameOk;
	}
	
	public static String getframeAddButton() {
		return "//*[@id='enroll_user_proceed']";
	}

	public static void setframenestedFrameId(String nestedFrameId) {
		Member_Page.nestedFrameId = nestedFrameId;
	}
	
	public static String getnestedFrameId() {
		return "//div[@id='enroll_user_modal'] //div[@class='modal-dialog'] //div[@class='modal-content']";
	}

	public static void setframeAddButton(String frameAddButton) {
		Member_Page.frameAddButton = frameAddButton;
	}
	
	public static String getAddMemberTabframe() {
		return addMemberTabframe;
	}

	public static void setAddMemberTabframe(String addMemberTabframe) {
		Member_Page.addMemberTabframe = addMemberTabframe;
	}

	public static String getFrameEmail() {
		return "//*[@id='user_email']";
	}

	public static void setFrameEmail(String frameEmail) {
		Member_Page.frameEmail = frameEmail;
	}

	public static String getFrameFirstName() {
		return "//*[@id='first_name']";
	}

	public static void setFrameFirstName(String frameFirstName) {
		Member_Page.frameFirstName = frameFirstName;
	}

	public static String getFrameLastName() {
		return "//*[@id='last_name']";
	}

	public static void setFrameLastName(String frameLastName) {
		Member_Page.frameLastName = frameLastName;
	}

	public static String getFrameID() {
		return "//*[@id='merchant_user_id']";
	}

	public static void setFrameID(String frameID) {
		Member_Page.frameID = frameID;
	}

	public static String getaddMemberTabframe() {
		return "//*[@id='enroll_user_modal']/div";
	}

	public static void setaddMemberTabframe(String addMemberTabframe) {
		Member_Page.addMemberTabframe = addMemberTabframe;
	}
	
	public static String getadd_new_member() {
		return "//*[@id='add_new_member']";
	}

	public static void setadd_new_member(String add_new_member) {
		Member_Page.add_new_member = add_new_member;
	}
}
