package com.neusoft.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
public class ShoppingBag implements Serializable {
	
	private static final long serialVersionUID = 8081074033197735778L;
	//购物袋商品的集合
	 private Map<Integer,CartItem> map=new LinkedHashMap<Integer,CartItem>();  
	 private double price;//所有购物项的价格总计  
	      
	    public void add(Product product){  
	        CartItem item=map.get(product.getId());  
	        if(item!=null){  
	            item.setQuantity(item.getQuantity()+1);  
	        }else{  
	            item=new CartItem();  
	            item.setProduct(product);  
	            item.setQuantity(1);  
	            //把新的购物项添加到map集合中  
	            map.put(product.getId(),item);
	        }  
	    }  
	    public Map<Integer, CartItem> getMap() {  
	        return map;  
	    }  
	    public void setMap(Map<Integer, CartItem> map) {  
	        this.map = map;  
	    }  
	    public double getPrice() {  
	        double totalprice=0;  
	        for(Map.Entry<Integer, CartItem> me:map.entrySet()){  
	            CartItem item=me.getValue();  
	            totalprice+=item.getPrice();  
	        }  
	        this.price=totalprice;  
	        return price;  
	    }  
	    public void setPrice(double price) {  
	        this.price = price;  
	    }  
	
}
