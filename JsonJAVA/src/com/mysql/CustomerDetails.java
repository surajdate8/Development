package com.mysql;

public class CustomerDetails {
	private String courseName,purchasedDate,location ;
	int amount;
	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int i) {
		this.amount = i;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void show() {
		System.out.println(amount+courseName+location+purchasedDate);
	}

}
