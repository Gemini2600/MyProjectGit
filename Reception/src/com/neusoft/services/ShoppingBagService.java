package com.neusoft.services;

import java.util.List;

import com.neusoft.dao.ShoppingBagDao;
import com.neusoft.dao.impl.ShoppingBagDaoImpl;
import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;
import com.neusoft.utils.DbUtil;

public class ShoppingBagService {
	ShoppingBagDao sbd=DbUtil.getInstance("shoppingBagDao", ShoppingBagDaoImpl.class);
	
	//��ѯȫ����Ʒ
	public List<Product> getAllProduct(){
		return sbd.getAllProduct();
	}
	//����id
	public Product findProduct(int id) {
		
		return sbd.findProduct(id);
	}
	//ɾ����Ʒ
	public void deleteCartItem(int sid, ShoppingBag shoppingBag) {
		sbd.deleteCartItem(sid, shoppingBag);
	}
	//��չ��ﳵ
	public void clearCart(ShoppingBag shoppingBag) {
		sbd.clearCart(shoppingBag);
	}
	//�ı�����
	public void changeQuantity(int sid, int quantity, ShoppingBag shoppingBag) {
		 sbd.changeQuantity(sid, quantity, shoppingBag);
	}
}
