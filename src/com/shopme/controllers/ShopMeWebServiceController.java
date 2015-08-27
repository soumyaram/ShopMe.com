package com.shopme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopme.web.model.ProductUpdateModel;

@RestController
@RequestMapping("/ws")
public class ShopMeWebServiceController {
	@RequestMapping("/product")
	public String getMessage(@PathVariable String name) {
		return "Request success for " + name;
	}

	@RequestMapping(name = "/product/update.html", method = RequestMethod.GET, headers = "content-type=application/json", produces = { "application/json" })
	public ResponseEntity<ProductUpdateModel> updateQuantity(
	/* @RequestBody ProductUpdateModel product */) {
		ProductUpdateModel updateModel = new ProductUpdateModel();
		updateModel.setNewPrice(1245.45);
		updateModel.setProductName("BMW 6");
		updateModel.setProductId(2);
		updateModel.setNewQuantity(10);
		return new ResponseEntity<ProductUpdateModel>(updateModel,
				HttpStatus.OK);
	}
}
