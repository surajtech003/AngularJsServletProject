package com.angular.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.angular.dao.ProductDao;
import com.angular.dto.Product;

import java.sql.PreparedStatement;

public class ProductDaoImpl implements ProductDao
{

	@Override
	public List<Product> getProducts(double minPrice, double maxPrice)
	{
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			pstmt = connection.prepareStatement("select * from products where price >=? and price <= ?");
			pstmt.setDouble(1, minPrice);
			pstmt.setDouble(2, maxPrice);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				product = new Product();
				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				list.add(product);
			}
			
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				pstmt.close();
				connection.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
