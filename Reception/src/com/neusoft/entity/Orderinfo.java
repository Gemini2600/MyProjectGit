package com.neusoft.entity;

import java.io.Serializable;

public class Orderinfo implements Serializable {

	private static final long serialVersionUID = -8723448739436708222L;
	private Integer id; //
	private String orderno;//订单编号
	private Integer orderstatus;//订单状态  1:未付款 2:已付款 3:已发货 4:已完成
	private Integer paystatus;//1:线上支付  2：货到付款
	private long ordertime;//下单时间
	private long paytime;//付款时间
	private Integer addrinfo;//收货人信息， 引用自cosumer_addr表中的id
	private String mask;//备注信息 
	public Orderinfo() {
		super();
	}
	public Orderinfo(String orderno, Integer orderstatus, Integer paystatus, long ordertime, long paytime,
			Integer addrinfo, String mask) {
		super();
		this.orderno = orderno;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinfo = addrinfo;
		this.mask = mask;
	}
	public Orderinfo(Integer id, String orderno, Integer orderstatus, Integer paystatus, long ordertime, long paytime,
			Integer addrinfo, String mask) {
		super();
		this.id = id;
		this.orderno = orderno;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinfo = addrinfo;
		this.mask = mask;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public Integer getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	public long getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(long ordertime) {
		this.ordertime = ordertime;
	}
	public long getPaytime() {
		return paytime;
	}
	public void setPaytime(long paytime) {
		this.paytime = paytime;
	}
	public Integer getAddrinfo() {
		return addrinfo;
	}
	public void setAddrinfo(Integer addrinfo) {
		this.addrinfo = addrinfo;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	@Override
	public String toString() {
		return "Orderinfo [id=" + id + ", orderno=" + orderno + ", orderstatus=" + orderstatus + ", paystatus="
				+ paystatus + ", ordertime=" + ordertime + ", paytime=" + paytime + ", addrinfo=" + addrinfo + ", mask="
				+ mask + "]";
	}
	
	
}
