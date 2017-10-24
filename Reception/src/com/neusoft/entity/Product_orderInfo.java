package com.neusoft.entity;

/**
 * 商品和订单中间实体类
 * @author Administrator
 *  orderid  int ,-- 订单id 值引用orderinfo表中的id
	productid int  , -- 商品id，值引用子product表中的id
	primary key(orderid,productid) -- 联合主键
 * 
 */
public class Product_orderInfo {

	public Product_orderInfo() {
		
	}

	private int orderid;
	
	private int productid;

	public int getOrderid() {
		return orderid;
	}
	public Product_orderInfo(int orderid, int productid) {
		super();
		this.orderid = orderid;
		this.productid = productid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "Product_orderInfo [orderid=" + orderid + ", productid=" + productid + "]";
	}

	
}
