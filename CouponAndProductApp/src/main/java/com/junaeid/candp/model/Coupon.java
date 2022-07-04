package com.junaeid.candp.model;

import java.math.BigDecimal;

public class Coupon {
	private int id;
	private String code;
	private String exp_date;
	private BigDecimal discount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExp_date() {
		return exp_date;
	}


	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "<h2>Coupon</h2> [ <br>id=" + id + ", <br>code=" + code + ", <br>exp_date=" + exp_date + ", <br>discount=" + discount + "]";
	}
}
