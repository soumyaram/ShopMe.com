package com.shopme.web.util;

import java.util.Random;


public class ShopMeUtil {

	public static String createOrderID(Integer productId) {
		return "SHME" + productId + "AVR" + new Random().nextInt(8888);
	}
}
