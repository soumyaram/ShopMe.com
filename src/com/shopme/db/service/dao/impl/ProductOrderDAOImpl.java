package com.shopme.db.service.dao.impl;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.shopme.db.model.Product;
import com.shopme.db.model.ProductNotification;
import com.shopme.db.model.ProductOrder;
import com.shopme.db.service.dao.ProductOrderDAO;
import com.shopme.web.model.Order;

public class ProductOrderDAOImpl implements ProductOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean registerForNotification(Order order) {
        Session session = sessionFactory.openSession();

        ProductNotification pNotification = new ProductNotification();
        pNotification.setProductId(order.getProductId());
        pNotification.setUserEmail(order.getEmail());
        pNotification.setStatus("P");
        pNotification.setQuantityRequested(order.getQty());

        session.saveOrUpdate(pNotification);
        return pNotification.getId() != null;
    }

    @Override
    public void saveOrderToDB(ProductOrder order) {
        Session session = sessionFactory.openSession();
        session.save(order);
    }

    @Override
    public ProductOrder purchaseProduct(ProductOrder order, Integer qty) {
        Session session = sessionFactory.openSession();

        Product product = (Product) session.get(Product.class, order.getProductId());
        product.setQtyAvailable(product.getQtyAvailable() - qty);
        order.setDate(Calendar.getInstance().getTime());
        session.update(product);
        session.close();
        session = sessionFactory.openSession();
        session.save(order);
        session.close();

        return order;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
