package com.neusoft.entity;

import java.io.Serializable;

//用于代表购买的商品。包括商品的数量。（购物项，购物车的一行）
public class CartItem implements Serializable {
	private static final long serialVersionUID = -2505917004788957586L;
	
	 private Product product; //购买的商品  
	 private int quantity;   //数量
	 private double price;//对此类商品的价格计算（小计） 
	 
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;  
        this.price=this.product.getPrice()*this.quantity;//商品的单价乘以数量 
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	 
}
