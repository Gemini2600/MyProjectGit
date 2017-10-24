package com.neusoft.entity;

import java.io.Serializable;

//���ڴ��������Ʒ��������Ʒ������������������ﳵ��һ�У�
public class CartItem implements Serializable {
	private static final long serialVersionUID = -2505917004788957586L;
	
	 private Product product; //�������Ʒ  
	 private int quantity;   //����
	 private double price;//�Դ�����Ʒ�ļ۸���㣨С�ƣ� 
	 
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
        this.price=this.product.getPrice()*this.quantity;//��Ʒ�ĵ��۳������� 
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	 
}
