package com.mysql;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonToJava {
	static Connection con=null;
	static String dir=System.getProperty("user.dir");




	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, JsonMappingException, IOException {
		
		ArrayList<CustomerDetails> a=new ArrayList<CustomerDetails>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root","root");

		Statement st=con.createStatement();
		st.executeQuery("use Business;");
		ResultSet rs=st.executeQuery("select * from CustomerInfo where Location ='Asia' limit 1");
		CustomerDetails c;
		while(rs.next()) {
			c=new CustomerDetails();
			c.setCourseName(rs.getString(1));

			c.setAmount(rs.getInt(3));
			c.setLocation(rs.getString(4));
			c.setPurchasedDate(rs.getString(2));

			a.add(c);
			System.out.println(rs.getString(1));
		}
		for(int i=0;i<a.size();i++) {
			ObjectMapper o=new ObjectMapper();
			o.writeValue(new File(dir+"/JSON/customerInfo"+i+".json"),a.get(i));
		}


		con.close();
	}
}