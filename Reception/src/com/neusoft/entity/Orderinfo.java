package com.neusoft.entity;

import java.io.Serializable;

public class Orderinfo implements Serializable {

	private static final long serialVersionUID = -8723448739436708222L;
	private Integer id; //
	private String orderno;//�������
	private Integer orderstatus;//����״̬  1:δ���� 2:�Ѹ��� 3:�ѷ��� 4:�����
	private Integer paystatus;//1:����֧��  2����������
	private long ordertime;//�µ�ʱ��
	private long paytime;//����ʱ��
	private Integer addrinfo;//�ջ�����Ϣ�� ������cosumer_addr���е�id
	private String mask;//��ע��Ϣ 
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
