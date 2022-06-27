package com.junaeid.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junaeid.mvc.model.AvgCalculator;

@WebServlet("/averageController")
public class AvgController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		AvgCalculator model = new AvgCalculator();
		int result = model.avg(num1, num2);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
		rd.forward(request, response);
	}
}
