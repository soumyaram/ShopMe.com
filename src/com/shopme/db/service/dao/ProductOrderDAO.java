package com.shopme.db.service.dao;

import com.shopme.db.model.ProductOrder;
import com.shopme.web.model.Order;

public interface ProductOrderDAO {
	
	public boolean registerForNotification(Order order);
	
	public void saveOrderToDB(ProductOrder order);
	
	public ProductOrder purchaseProduct(ProductOrder order, Integer qty);

}
