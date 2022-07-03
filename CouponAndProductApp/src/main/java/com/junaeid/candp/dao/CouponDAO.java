package com.junaeid.candp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
