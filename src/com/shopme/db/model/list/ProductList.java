package com.shopme.db.model.list;

import java.util.ArrayList;
import java.util.List;

import com.shopme.db.model.Product;

public class ProductList {
	private List<Product> productList = new ArrayList<>();

	public ProductList(List<Product> products) {
		this.productList = products;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
