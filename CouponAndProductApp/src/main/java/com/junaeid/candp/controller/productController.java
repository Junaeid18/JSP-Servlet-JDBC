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
import com.junaeid.candp.dao.ProductDAO;
import com.junaeid.candp.model.Coupon;
import com.junaeid.candp.model.Product;

/**
 * Servlet implementation class productController
 */
@WebServlet("/productController")
public class productController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CouponDAO c = new CouponDAO();
    private ProductDAO p = new ProductDAO();
	public productController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String des = request.getParameter("desc");
		String price = request.getParameter("price");
		String code = request.getParameter("code");
		Coupon coupon = c.findCoupon(code);
		
		Product pro = new Product();
		pro.setName(name);
		pro.setDescription(des);
		pro.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
		
		p.addProduct(pro);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Product Added!</h1>");
		out.print("<br/>");
		out.println("<h1><a href='/CouponAndProductApp'>Home</a></h1>");
		
	}

}
