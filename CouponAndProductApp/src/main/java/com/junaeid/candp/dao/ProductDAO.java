package com.junaeid.candp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.junaeid.candp.model.Product;
import com.junaeid.candp.util.ConnectionUtil;

public class ProductDAO {
	public void addProduct(Product p) {
		Connection conn = ConnectionUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("insert into products(name,desciption,price) values(?,?,?)");
			pst.setString(1, p.getName());
			pst.setString(2, p.getDescription());
			pst.setBigDecimal(3, p.getPrice());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
