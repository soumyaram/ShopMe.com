package com.shopme.db.service;

import com.shopme.db.model.Product;
import com.shopme.db.model.list.ProductList;
import com.shopme.db.service.dao.impl.ProductDAOImpl;

public class ProductDBService {
	private ProductDAOImpl productDAO = new ProductDAOImpl();

	public ProductList getProducts() {
		return productDAO.getAllProducts();
	}

	public Product getProduct(Integer productId) {
		return productDAO.getProduct(productId);
	}

	public void addReminder(String email, Integer productId) {
		productDAO.addReminder(email, productId);
	}
}
