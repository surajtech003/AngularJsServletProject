package com.angular.service.impl;

import java.util.List;

import com.angular.dao.ProductDao;
import com.angular.dao.impl.ProductDaoImpl;
import com.angular.dto.Product;
import com.angular.service.ProductService;
import com.angular.util.JsonUtil;

public class ProductServiceImpl implements ProductService
{

	@Override
	public String getProjects(double minPrice, double maxPrice)
	{
		ProductDao productDao = new ProductDaoImpl();
		List<Product> list = productDao.getProducts(minPrice, maxPrice);
		String jsonProductList = JsonUtil.convertJavaToJson(list);
		return jsonProductList;
	}

}
