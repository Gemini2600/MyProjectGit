package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;

public interface ShoppingBagDao {
	 public List<Product> getAllProduct();  
	    //获取指定id的书  
	    public Product findProduct(int id);  
	//删除购物项  
	    public void deleteCartItem(int sid, ShoppingBag shoppingBag);  
	    //清空购物车  
	    public void clearCart(ShoppingBag shoppingBag);  
	    //改变数量  
	    public void changeQuantity(int sid, int quantity, ShoppingBag shoppingBag);
}
