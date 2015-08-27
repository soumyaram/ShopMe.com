package com.shopme.db.service.dao;

import java.util.List;

import com.shopme.db.model.Product;
import com.shopme.web.model.Order;

public interface ProductDAO {
	public Product findProductById(Integer productId);

	public List<Product> getProducts(int start, int offset);

	public Product updateProduct(Product product);

	public Product save(Product product);

	public boolean validatePurchase(Order order);
}
