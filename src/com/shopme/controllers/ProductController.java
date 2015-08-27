package com.shopme.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shopme.db.model.Product;
import com.shopme.db.model.ProductOrder;
import com.shopme.db.service.dao.ProductDAO;
import com.shopme.db.service.dao.ProductOrderDAO;
import com.shopme.web.model.Order;
import com.shopme.web.model.ProductServiceModel;
import com.shopme.web.model.converter.DataConverter;
import com.shopme.web.util.ShopMeUtil;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductDAO      productDAO;
    @Autowired
    private ProductOrderDAO orderDAO;

    @RequestMapping(value = "/show/{productId}/view.html")
    public @ResponseBody
    ProductServiceModel getProduct(Integer productId) {
        return viewAllProducts().get(0);
    }

    @RequestMapping(value = "/show/all.html")
    public @ResponseBody
    List<ProductServiceModel> viewAllProducts() {

        List<Product> allProducts = productDAO.getProducts(0, 10);
        return DataConverter.convertToProductServiceModel(allProducts);
    }
    
    @RequestMapping(value = "buy/createorder.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> confirmPurchase(@RequestBody Order order) {
        boolean status = productDAO.validatePurchase(order);

        Map<String, String> orderStatus = new HashMap<>();
        orderStatus.put("Available", String.valueOf(status));
        orderStatus.put("OrderID", ShopMeUtil.createOrderID(order.getProductId()));
        if (status) {
            orderStatus.put("Message",
                    "Requested quantity available, please wait while we processing your request.... ");
        } else {
            orderStatus
                    .put("Message",
                            "Sorry, Requested quantity not available in stock, Do you want to get noticed when new stock added");
        }
        return orderStatus;
    }

    @RequestMapping(value = "buy/reminder.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> registerEmailForNotification(@RequestBody Order order) {
        boolean status = orderDAO.registerForNotification(order);
        Map<String, Object> registerStatus = new HashMap<>();
        registerStatus.put("status", status);
        registerStatus.put("Message", "Success");
        return registerStatus;
    }

    @RequestMapping(value = "buy/finalize.html", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> purchaseProduct(@RequestBody Order order) {
        ProductOrder productOrder = orderDAO.purchaseProduct(DataConverter.convertOrderToProductOrder(order), order.getQty());
        Map<String, Object> purchaseRecord = new HashMap<>();
        purchaseRecord.put("status", productOrder.getId() != null);
        purchaseRecord.put("Message", "Success");
        purchaseRecord.put("OrderID", ShopMeUtil.createOrderID(productOrder.getId()));
        return purchaseRecord;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void setOrderDAO(ProductOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

}
