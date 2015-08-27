package com.shopme.web.model.converter;

import java.util.ArrayList;
import java.util.List;

import com.shopme.db.model.Product;
import com.shopme.db.model.ProductOrder;
import com.shopme.web.model.Order;
import com.shopme.web.model.ProductServiceModel;
import com.shopme.web.model.ProductUpdateModel;

public class DataConverter {

	public static ProductServiceModel convertToProductServiceModel(
			Product product) {
		ProductServiceModel serviceModel = new ProductServiceModel();
		serviceModel.setId(product.getId());
		serviceModel.setName(product.getName());
		serviceModel.setImageUrl(product.getImageUrl());
		serviceModel.setColor(product.getColor());
		serviceModel.setCountry(product.getCountry());
		serviceModel.setPrice(product.getPrice());
		serviceModel.setQtyAvailable(product.getQtyAvailable());
		serviceModel.setReorderLevel(product.getReorderLevel());

		return serviceModel;
	}

	public Product convertToProductModel(ProductServiceModel productServiceModel) {
		Product productModel = new Product();
		productModel.setId(productServiceModel.getId());
		productModel.setName(productServiceModel.getName());
		productModel.setImageUrl(productServiceModel.getImageUrl());
		productModel.setColor(productServiceModel.getColor());
		productModel.setCountry(productServiceModel.getCountry());
		productModel.setPrice(productServiceModel.getPrice());
		productModel.setQtyAvailable(productServiceModel.getQtyAvailable());
		productModel.setReorderLevel(productServiceModel.getReorderLevel());

		return productModel;
	}

	public Product convertUpdateModelToProduct(Product product,
			ProductUpdateModel updateModel) {

		product.setName(updateModel.getProductName());
		product.setPrice(String.valueOf(updateModel.getNewPrice()));
		product.setQtyAvailable(product.getQtyAvailable()
				+ updateModel.getNewQuantity());

		return product;
	}

	public static List<ProductServiceModel> convertToProductServiceModel(
			List<Product> allProducts) {
		List<ProductServiceModel> serviceProducts = new ArrayList<>(
				allProducts.size());
		for (Product p : allProducts) {
			serviceProducts.add(convertToProductServiceModel(p));
		}
		return serviceProducts;
	}
	
	public static ProductOrder convertOrderToProductOrder(Order order) {
		
		ProductOrder pOrder = new ProductOrder();
		pOrder.setProductId(order.getProductId());
		pOrder.setName(order.getName());
		pOrder.setUserEmail(order.getEmail());
		pOrder.setAddress(order.getAddress());
		
		return pOrder;
	}
	
	public static Order convertProductOrderToOrder(ProductOrder order) {
		
		Order sOrder = new Order();
		sOrder.setProductId(order.getProductId());
		sOrder.setName(order.getName());
		sOrder.setEmail(order.getUserEmail());
		sOrder.setAddress(order.getAddress());
		
		return sOrder;
	}
}

