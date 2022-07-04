package com.junaeid.candp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junaeid.candp.dao.CouponDAO;
import com.junaeid.candp.model.Coupon;


@WebServlet("/couponController")
public class couponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CouponDAO cdao = new CouponDAO();   
    public couponController() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("create")) {
			createCoupon(request, response);			
		}else if(action.equals("find")) {
			findCoupon(request, response);
		}
		
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		String exp = request.getParameter("exp");
		String dis = request.getParameter("discount");
		
		Coupon c = new Coupon();
		c.setCode(code);
		c.setExp_date(exp);
		c.setDiscount(new BigDecimal(dis));
		
		cdao.CreateCoupon(c);
		PrintWriter out = response.getWriter();
		out.println("<b>Coupon Created!</b>");
		out.println("<a href='/CouponAndProductApp'>Home</a>");
	}
	
	private void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
	
		Coupon findCoupon = cdao.findCoupon(code);
		
		PrintWriter out = response.getWriter();
		out.println("<b>Coupon Found!</b>");
		out.println(findCoupon);
		out.println("<br/>");
		out.println("<a href='/CouponAndProductApp'>Home</a>");
	}

}
