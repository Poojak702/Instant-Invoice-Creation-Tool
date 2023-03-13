package com.alacriti.invoiceCreation.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.invoiceCreation.dbConnection.DbConnection;
import com.alacriti.invoiceCreation.vo.User;

public class UserDAO {

	private static Logger log = Logger.getLogger(UserDAO.class.getName());
	DbConnection db = new DbConnection();

	public User signUp(User user) {

		log.info("in UserDAO--->signUp Method starts.");
		try {
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			String query = "insert into AL454_User_tbl(first_name,last_name,email,pass_word,confirm_pass_word) values(?,?,?,?,?)";
			int index = 1;

			PreparedStatement st = con.prepareStatement(query);
			st.setString(index++, user.getFirstName());
			st.setString(index++, user.getLastName());
			st.setString(index++, user.getEmail());
			st.setString(index++, user.getPassword());
			st.setString(index++, user.getConfirmPassword());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		log.info("in UserDAO--->signUp Method end.");
		return user;

	}

	public User login(User user) {

		User userDetails = new User();
		log.info("in UserDAO--->login Method starts.");
		
		try {
						
			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			String query = "select user_id , first_name , last_name , email , photo From AL454_User_tbl where email = ? and pass_word = ?";
			PreparedStatement st = connection.prepareStatement(query);
			int index = 1;
			st.setString(index++, user.getEmail());
			st.setString(index++, user.getPassword());
			ResultSet rs = st.executeQuery();
			index = 1;

			while (rs.next()) {
				
				userDetails.setId(rs.getInt(index++));
				userDetails.setFirstName(rs.getString(index++));
				userDetails.setLastName(rs.getString(index++));
				userDetails.setEmail(rs.getString(index++));
				userDetails.setPhotoPath(rs.getString(index++));
				System.out.println(userDetails);
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		log.info("in UserDAO--->login Method ends.");
		return userDetails;
	}

	public User getUserById(int id) {

		log.info("in UserDAO--->getUserById Method starts.");
		String query = "SELECT user_id , first_name , last_name , email , address , state , pin_code , photo from AL454_User_tbl where user_id = "+ id;
		User user = new User();
		
		try {
			
			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int index = 1;

			if (rs.next()) {
				
				user.setId(rs.getInt(index++));
				user.setFirstName(rs.getString(index++));
				user.setLastName(rs.getString(index++));
				user.setEmail(rs.getString(index++));
				user.setAddress(rs.getString(index++));
				user.setState(rs.getString(index++));
				user.setPinCode(rs.getLong(index++));
				user.setPhotoPath(rs.getString(index++));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		log.info("in UserDAO--->getUserById Method ends.");
		return user;
	}

	public int updateProfile(User user) {

		log.info("in UserDAO--->updateProfile Method starts.");
		String sql = "update AL454_User_tbl set photo = ? where user_id = ?";
		int rowsUpdated = 0;

		try {

			int index = 1;
			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(index++, user.getPhotoPath());
			st.setInt(index++, user.getId());
			rowsUpdated = st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("in UserDAO--->updateProfile Method end.");
		return rowsUpdated;
	}

	public int updateUserDetails(User user) {

		log.info("in UserDAO--->updateUserDetails Method starts.");
		int rowsUpdated = 0;
		String sql = "update AL454_User_tbl set first_name = ? , last_name = ? , email = ? , address = ? , city = ? , state = ? , pin_code = ? where user_id = ?";
		
		try {
			
			int index = 1;
			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(index++, user.getFirstName());
			st.setString(index++, user.getLastName());
			st.setString(index++, user.getEmail());
			st.setString(index++, user.getAddress());
			st.setString(index++, user.getCity());
			st.setString(index++, user.getState());
			st.setLong(index++, user.getPinCode());
			st.setInt(index++, user.getId());
			rowsUpdated = st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("in UserDAO--->updateUserDetails Method end.");
		return rowsUpdated;
	}

}
