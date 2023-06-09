package com.fpoly.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.fpoly.model.DB;
import com.fpoly.model.Product;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	Map<Integer, Product> map = new HashMap<>();
	
	@Override
	public Product add(Integer id) {
		// TODO Auto-generated method stub
		Product pd = map.get(id);
		if(pd == null) { // Chưa có trong giỏ hàng
			pd = DB.Products.get(id);
			pd.setQty(1);
			map.put(id, pd);
		}else {
			pd.setQty(pd.getQty()+1);
		}
		return pd;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public Product update(Integer id, int qty) {
		Product pd = map.get(id);
		if(pd != null) {
			pd.setQty(qty);
		}
		return pd;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<Product> getItems() {
		return map.values();
	}

	@Override
	public int getCount() {
		final int[] number = {0};
		map.forEach((key, value) -> {
			number[0] += value.getQty();
		});
		return number[0];
	}

	@Override
	public double getAmount() {
		final double[] sumAmount = {0};
		map.forEach((key, value) -> {
			sumAmount[0] = value.getPrice() * value.getQty();
		});
		return sumAmount[0];
	}

}
