package com.neusoft.dao.impl;


import java.util.List;

import com.neusoft.dao.ProductDao;
import com.neusoft.dao.ShoppingBagDao;
import com.neusoft.entity.CartItem;
import com.neusoft.entity.Product;
import com.neusoft.entity.ShoppingBag;
import com.neusoft.utils.DbUtil;

public class ShoppingBagDaoImpl implements ShoppingBagDao {
	ProductDao pd=DbUtil.getInstance("productDao", ProductDaoImpl.class);
	
	@Override
	public List<Product> getAllProduct() {
		
		return pd.getProductList();
	}

	@Override
	public Product findProduct(int id) {
		
		return pd.getproductById(id);
	}

	@Override
	public void deleteCartItem(int sid, ShoppingBag shoppingBag) {
		shoppingBag.getMap().remove(sid);
		
	}

	@Override
	public void clearCart(ShoppingBag shoppingBag) {
		shoppingBag.getMap().clear();
		
	}

	@Override
	public void changeQuantity(int sid, int quantity, ShoppingBag shoppingBag) {
		 CartItem item=shoppingBag.getMap().get(sid);  
	     item.setQuantity(quantity);
		
	}

	
	
}
