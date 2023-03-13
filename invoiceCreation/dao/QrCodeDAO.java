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
import com.alacriti.invoiceCreation.vo.QrCode;

public class QrCodeDAO {

	private static Logger log = Logger.getLogger(QrCodeDAO.class.getName());
	DbConnection db = new DbConnection();

	public List<QrCode> getQrCodes() {

		log.info("in QrCodeDAO--->getQrCodes Method starts.");
		List<QrCode> qrCodeList = new ArrayList<>();
		String sql = "select *from Movie";

		try {

			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				QrCode qrCode = new QrCode(rs.getString(2), rs.getString(3));
				qrCodeList.add(qrCode);
				System.out.println(qrCodeList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		log.info("in QrCodeDAO--->getQrCodes Method ends.");
		return qrCodeList;

	}

	public QrCode addQrCode(QrCode qrCode) {

		log.info("in QrCodeDAO--->addQrCode Method starts.");
		String sql = "insert into AL454_QR_code_tbl(shop_name,shop_QR_code) values(?,?)";
		int index = 1;

		try {

			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(index++, qrCode.getShopName());
			st.setString(index++, qrCode.getShopQrCodePath());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		log.info("in QrCodeDAO--->addQrCode Method ends.");
		return qrCode;
	}

	public String compareShopName(String shopName) {

		log.info("in QrCodeDAO--->compareShopName Method starts.");
		String sql = "select shop_name From AL454_QR_code_tbl where shop_name='+shopName+'";
		String result = null;
		
		try {

			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			Statement pstmt = connection.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			System.out.println("rs result:" + rs.getString("shop_name"));

			if (rs.next()) {
				result = (rs.getString("shop_name").equals(shopName)) ? shopName : "shop not found";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("in QrCodeDAO--->compareShopName Method ends.");
		return result;
	}

	public List<QrCode> getAllPaths() {

		log.info("in QrCodeDAO--->getAllPaths Method starts.");
		List<QrCode> qrcode = new ArrayList<>();
		String sql = "select *from AL454_QR_code_tbl";

		try {
			Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				QrCode qrcodeList = new QrCode(rs.getString(2), rs.getString(3));
				qrcode.add(qrcodeList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("in QrCodeDAO--->getAllPaths Method ends.");
		return qrcode;
	}

}
