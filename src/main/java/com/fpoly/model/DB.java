package com.fpoly.model;

import java.util.HashMap;
import java.util.Map;

public class DB {
	public static Map<Integer, Product> Products = new HashMap<>();
	static {
		Products.put(1, new Product(1, "Casio MTP-1374L-1AVDF Nam", 1000, 0,"dongho1.jpg"));
		Products.put(2, new Product(2, "Casio AE-1200WHD-1AVDF Nam", 2000, 0,"dongho2.jpg"));
		Products.put(3, new Product(3, "Casio MTP-1374D-1AVDF Nam", 1500, 0,"dongho3.jpg"));
		Products.put(4, new Product(4, "Casio LTP-V300L-4AUDF Nữ", 3000, 0,"dongho4.jpg"));
	}
}
