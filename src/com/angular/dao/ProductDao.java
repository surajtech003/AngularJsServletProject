package com.angular.dao;

import java.util.List;

import com.angular.dto.Product;

public interface ProductDao
{
	public List<Product> getProducts(double minPrice, double maxPrice);
}
