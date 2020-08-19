package com.zinrelo.pages;

public class Login_Page {
	static String password,forgetYourPassword,signUp,login,email,alertMSG;
	

	public Login_Page() {
		password="//*[@id='id_password']";
		forgetYourPassword="//*[@id='id_reset_password_email']";
		signUp="//*[@id='id_redirect_signup']";
		login="//*[@id='id_login_button']";
		email="//*[@id='id_email']";
		alertMSG="//*[@id='alert_msg']";
	}
	
	public static String getalertMSG() {
		return alertMSG;
	}

	public static void setalertMSG(String alertMSG) {
		Login_Page.alertMSG = alertMSG;
	}
	
	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Login_Page.password = password;
	}

	public static String getForgetYourPassword() {
		return forgetYourPassword;
	}

	public static void setForgetYourPassword(String forgetYourPassword) {
		Login_Page.forgetYourPassword = forgetYourPassword;
	}

	public static String getSignUp() {
		return signUp;
	}

	public static void setSignUp(String signUp) {
		Login_Page.signUp = signUp;
	}

	public static String getLogin() {
		return login;
	}

	public static void setLogin(String login) {
		Login_Page.login = login;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Login_Page.email = email;
	}
	
	public void show() {
		System.out.println(email);
		System.out.println(login);
		System.out.println(email);
		System.out.println(email);
		System.out.println(email);
	}

}
