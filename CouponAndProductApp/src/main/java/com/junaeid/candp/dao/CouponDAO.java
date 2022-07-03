package com.junaeid.candp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.junaeid.candp.model.Coupon;
import com.junaeid.candp.util.ConnectionUtil;

public class CouponDAO {
	public void CreateCoupon(Coupon cp) {
		Connection conn = ConnectionUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("insert into coupon(code,exp_date,discount) values(?,?,?)");
			pst.setString(1, cp.getCode());
			pst.setString(2, cp.getExp_date());
			pst.setBigDecimal(3, cp.getDiscount());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Coupon findCoupon(String code) {
		Coupon c = new Coupon();
		Connection conn = ConnectionUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("select * from coupon where code=?");
			pst.setString(1, code);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setCode(rs.getString(2));
				c.setExp_date(rs.getString(3));
				c.setDiscount(rs.getBigDecimal(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
