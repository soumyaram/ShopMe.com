package com.shopme.controllers;

import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopme.db.model.Product;
import com.shopme.db.service.dao.impl.ProductDAOImpl;

@Controller
public class ShopMeHomeController {
    @Autowired
    private ProductDAOImpl productDAO;

    @RequestMapping("/welcome")
    public ModelAndView welcomeShopme() {
        String message = "<br><div style='text-align:center;'>" + "<h3> Welcome to ShopMe.com</h3>";

        Product product = productDAO.findProductById(1);
        System.out.println(product);
        List<Product> allProducts = productDAO.getProducts(0, 10);
        System.out.println(allProducts);
        return new ModelAndView("ShopMe", "message", message);
    }

    @RequestMapping(value = "product.html")
    public ModelAndView getProduct() {
        return new ModelAndView("Product");
    }

    @RequestMapping(value = "finalize.html")
    public ModelAndView buyProduct() {
        return new ModelAndView("BuyProduct");
    }

    public ModelAndView getAllProducts() {
        return null;
    }

    public ProductDAOImpl getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

}