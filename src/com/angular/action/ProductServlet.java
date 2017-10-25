package com.angular.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angular.service.ProductService;
import com.angular.service.impl.ProductServiceImpl;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductService productService = null;
	public void init() 
	{
		productService = new ProductServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		double minPrice = Double.parseDouble(request.getParameter("minPrice"));
		double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
		
		String jsonOutput = productService.getProjects(minPrice, maxPrice);
		System.out.println(jsonOutput);
		response.setContentType("application/json");
		response.getWriter().write(jsonOutput);
	}

}
