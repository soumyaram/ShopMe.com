package com.shopme.db.service.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shopme.db.model.Product;
import com.shopme.db.model.list.ProductList;
import com.shopme.db.service.dao.DBConnection;
import com.shopme.db.service.dao.ProductDAO;
import com.shopme.web.model.Order;

public class ProductDAOImpl implements ProductDAO {

	private final static String PRODUCT_TABLE = "products";
	private final static String REMINDER_TABLE = "product_notification";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Product getProduct(Integer productId) {

		Product product = new Product();
		try {
			PreparedStatement pstmt = DBConnection.getConnection()
					.prepareStatement(
							"SELECT * FROM " + PRODUCT_TABLE + " WHERE id = ?");
			pstmt.setInt(1, productId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setImageUrl(rs.getString("image_url"));
				product.setPrice(rs.getString("price"));
				product.setReorderLevel(rs.getInt("reorder_level"));
				product.setColor(rs.getString("color"));
				product.setCountry(rs.getString("country"));
				product.setQtyAvailable(rs.getInt("qty_available"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	public ProductList getAllProducts() {

		List<Product> products = new ArrayList<>();
		try {
			PreparedStatement pstmt = DBConnection.getConnection()
					.prepareStatement("SELECT * FROM " + PRODUCT_TABLE);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setImageUrl(rs.getString("image_url"));
				product.setPrice(rs.getString("price"));
				product.setReorderLevel(rs.getInt("reorder_level"));
				product.setColor(rs.getString("color"));
				product.setCountry(rs.getString("country"));
				product.setQtyAvailable(rs.getInt("qty_available"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductList productList = new ProductList(products);
		return productList;
	}

	public void addReminder(String email, Integer productId) {
		try {
			PreparedStatement pstmt = DBConnection.getConnection()
					.prepareStatement(
							"insert into " + REMINDER_TABLE
									+ " values(null, ?, ?, 'P', null)");
			pstmt.setInt(1, productId);
			pstmt.setString(2, email);

			int resultCount = pstmt.executeUpdate();
			System.out.println(resultCount);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts(int start, int offset) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.close();
		return products;
	}

	@Override
	public Product findProductById(Integer productId) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, productId);

		session.close();
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(product);
		return product;
	}

	@Override
	public Product save(Product product) {
		Session session = sessionFactory.openSession();
		session.save(product);
		return product;
	}
	
	public boolean validatePurchase(Order order) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, order.getProductId());
		if (order.getQty() > product.getQtyAvailable()) {
			return false;
		} else {
			return true;
		}
	}
}
