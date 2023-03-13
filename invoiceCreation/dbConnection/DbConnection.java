package com.alacriti.invoiceCreation.dbConnection;


public class DbConnection {

	private String url = "jdbc:mysql://192.168.35.147:3306/testdb";
	private String user = "testdb";
	private String password = "testdb";

	public DbConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
