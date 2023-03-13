package com.alacriti.invoiceCreation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.invoiceCreation.dbConnection.DbConnection;
import com.alacriti.invoiceCreation.vo.Item;

public class ItemDAO {

	private static Logger log = Logger.getLogger(ItemDAO.class.getName());
	DbConnection db = new DbConnection();

	public List<Item> addItems(List<Item> items) {

		log.info("in ItemDAO--->addItems Method starts.");
		int billId = getBillId();
		String sql = "insert into AL454_bill_items_tbl (item_name , price , bill_id) values(?,?,?)";
		
		for (Item item1 : items) {
			System.out.println("Adding table");
//			billId++;
			item1.setBillId(billId);
			
			try {
				
				Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
				PreparedStatement st = connection.prepareStatement(sql);
				int index = 1;
				st.setString(index++, item1.getItemName());
				st.setInt(index++, item1.getItemPrice());
				st.setInt(index++, billId);
				st.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		log.info("in ItemDAO--->addItems Method ends.");
		return items;
	}

	public void addBill(Item item) throws SQLException {
		
		log.info("in ItemDAO--->addBill Method starts.");
		String sql = "insert into AL454_bill_tbl ( user_id , bill_path) values(?,?)";
		System.out.println("userId : " + item.getUserId());
		Connection connection = null;
		PreparedStatement st = null;
		
		try {
			connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			st = connection.prepareStatement(sql);
			int index = 1;
			st.setInt(index++, item.getUserId());
			st.setString(index++, item.getBillPath());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			if (connection != null) {
				st.close();
				connection.close();
			}
		}
		
		log.info("in ItemDAO--->addBill Method ends.");
	}

	public int getBillId() {
		
		log.info("in ItemDAO--->getBillId Method starts.");
		String sql = "SELECT bill_id FROM AL454_bill_tbl ORDER BY bill_id  DESC LIMIT 1";
		int billId = 0;
		int index = 1;

		try {
			
			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				billId = rs.getInt(index);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		log.info("in ItemDAO--->getBillId Method ends.");
		return billId;
	}

	public List<Item> getItemsById(int id) {

		log.info("in ItemDAO--->getItemsById Method starts.");
		List<Item> items = new ArrayList<>();
		String sql = "SELECT bill_id , item_name , price FROM AL454_bill_items_tbl where bill_id = ?";

		try {
			
			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet resultSet = st.executeQuery();
			int index = 1;

			while (resultSet.next()) {
				index = 1;
				Item item = new Item();
				item.setBillId(resultSet.getInt(index++));
				item.setItemName(resultSet.getString(index++));
				item.setItemPrice(resultSet.getInt(index++));
				items.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("in ItemDAO--->getItemsById Method ends.");
		return items;
	}

	public List<Item> getBillPathByUserId(Item item) {

		log.info("in ItemDAO--->getBillPathByUserId Method starts.");
		String sql = "SELECT bill_id , bill_path from AL454_bill_tbl where user_id  = ?";
		int index = 1;
		List<Item> items = new ArrayList<>();

		try {
			
			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, item.getUserId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				index = 1;
				Item item1 = new Item();
				item1.setBillId(rs.getInt(index++));
				item1.setBillPath(rs.getString(index++));
				items.add(item1);
				System.out.println("item :" + item);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		log.info("in ItemDAO--->getBillPathByUserId Method ends.");
		return items;

	}

}
