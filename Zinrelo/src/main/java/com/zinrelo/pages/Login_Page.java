package com.zinrelo.pages;

public class Login_Page {
	static String password,forgetYourPassword,signUp,login,email,alertMSG;
	
	public static String getalertMSG() {
		return "//*[@id='alert_msg']";
	}

	public static void setalertMSG(String alertMSG) {
		Login_Page.alertMSG = alertMSG;
	}
	
	public static String getPassword() {
		return "//*[@id='id_password']";
	}

	public static void setPassword(String password) {
		Login_Page.password = password;
	}

	public static String getForgetYourPassword() {
		return "//*[@id='id_reset_password_email']";
	}

	public static void setForgetYourPassword(String forgetYourPassword) {
		Login_Page.forgetYourPassword = forgetYourPassword;
	}

	public static String getSignUp() {
		return "//*[@id='id_redirect_signup']";
	}

	public static void setSignUp(String signUp) {
		Login_Page.signUp = signUp;
	}

	public static String getLogin() {
		return "//*[@id='id_login_button']";
	}

	public static void setLogin(String login) {
		Login_Page.login = login;
	}

	public static String getEmail() {
		return "//*[@id='id_email']";
	}

	public static void setEmail(String email) {
		Login_Page.email = email;
	}
}
