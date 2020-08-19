package com.zinrelo.pages;

public class Member_Page {
	
	public static String add_new_member,addMemberTabframe;
	public static String frameEmail,frameFirstName,frameLastName,frameID,frameAddButton;
	public static String nestedFrameId,nestedFrameOk,nestedFrameAlertMsg;
	public static String addedName,addedEmail;
	
	public static String getAddedName() {
		return addedName;
	}

	public static void setAddedName(String addedName) {
		Member_Page.addedName = addedName;
	}

	public static String getAddedEmail() {
		return addedEmail;
	}

	public static void setAddedEmail(String addedEmail) {
		Member_Page.addedEmail = addedEmail;
	}

	public static String getnestedFrameAlertMsg() {
		return nestedFrameAlertMsg;
	}

	public static void setnestedFrameAlertMsg(String nestedFrameAlertMsg) {
		Member_Page.nestedFrameAlertMsg = nestedFrameAlertMsg;
	}
	
	public static String getnestedFrameOk() {
		return nestedFrameOk;
	}

	public static void setnestedFrameOk(String nestedFrameOk) {
		Member_Page.nestedFrameOk = nestedFrameOk;
	}
	
	public static String getframeAddButton() {
		return frameAddButton;
	}

	public static void setframenestedFrameId(String nestedFrameId) {
		Member_Page.nestedFrameId = nestedFrameId;
	}
	
	public static String getnestedFrameId() {
		return nestedFrameId;
	}

	public static void setframeAddButton(String frameAddButton) {
		Member_Page.frameAddButton = frameAddButton;
	}
	
	public static String getAdd_new_member() {
		return add_new_member;
	}

	public static void setAdd_new_member(String add_new_member) {
		Member_Page.add_new_member = add_new_member;
	}

	public static String getAddMemberTabframe() {
		return addMemberTabframe;
	}

	public static void setAddMemberTabframe(String addMemberTabframe) {
		Member_Page.addMemberTabframe = addMemberTabframe;
	}

	public static String getFrameEmail() {
		return frameEmail;
	}

	public static void setFrameEmail(String frameEmail) {
		Member_Page.frameEmail = frameEmail;
	}

	public static String getFrameFirstName() {
		return frameFirstName;
	}

	public static void setFrameFirstName(String frameFirstName) {
		Member_Page.frameFirstName = frameFirstName;
	}

	public static String getFrameLastName() {
		return frameLastName;
	}

	public static void setFrameLastName(String frameLastName) {
		Member_Page.frameLastName = frameLastName;
	}

	public static String getFrameID() {
		return frameID;
	}

	public static void setFrameID(String frameID) {
		Member_Page.frameID = frameID;
	}

	public static String getaddMemberTabframe() {
		return addMemberTabframe;
	}

	public static void setaddMemberTabframe(String addMemberTabframe) {
		Member_Page.addMemberTabframe = addMemberTabframe;
	}
	
	public static String getadd_new_member() {
		return add_new_member;
	}

	public static void setadd_new_member(String add_new_member) {
		Member_Page.add_new_member = add_new_member;
	}

	public Member_Page(){
		add_new_member="//*[@id='add_new_member']";
		addMemberTabframe="//*[@id='enroll_user_modal']/div";
		frameEmail="//*[@id='user_email']";
		frameFirstName="//*[@id='first_name']";
		frameLastName="//*[@id='last_name']";
		frameID="//*[@id='merchant_user_id']";
		frameAddButton="//*[@id='enroll_user_proceed']";
		nestedFrameId="//div[@id='enroll_user_modal'] //div[@class='modal-dialog'] //div[@class='modal-content']";
		nestedFrameOk="//a[@id='enroll_user_success']";
		nestedFrameAlertMsg="//div[@id='enroll_alert_box']/span";
		addedName="//div[@id='customer_list'] /div/table/tbody/tr[1]/td[2]/a";
		addedEmail="//div[@id='customer_list'] /div/table/tbody/tr[1]/td[2]/span";
	}
	
	

}
