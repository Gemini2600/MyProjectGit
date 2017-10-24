package com.neusoft.entity;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;//��Ʒ���
	private String pname;//��Ʒ����
	private int cid;//�ϼ�����id
	private String pno;//����
	private String pic;//��ƷͼƬ
	private double price;//��Ʒ�۸�
	private int online;//1 �ϼ� 0�¼�
	private String pdetail;//��Ʒ����
	private int number;//��Ʒ����
	public Product() {
		super();
	}
	
	public Product(int id, String pname, int cid, String pno) {
		super();
		this.id = id;
		this.pname = pname;
		this.cid = cid;
		this.pno = pno;
	}

	public Product(int id, String pname, int cid, String pno, String pic, double price, int online, String pdetail) {
		super();
		this.id = id;
		this.pname = pname;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
	}
	public Product(String pname, int cid, String pno, String pic, double price, int online, String pdetail) {
		super();
		this.pname = pname;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	//��дhashCode��equals����
	@Override  
    public int hashCode() {  
          
        return this.getId() + this.getPname().hashCode();  
      
    }  
  
    @Override  
    public boolean equals(Object obj) {  
        if (this == obj)  
            return true;  
        if(obj == null) {  
            return false;  
        }  
        if(obj instanceof Product) {  
            Product i = (Product)obj;  
            if(this.getId() == i.getId() && this.getPname().equals(i.getPname())) {  
                return true;  
            } else {  
                return false;  
            }  
        } else {  
            return false;  
        }  
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", cid=" + cid + ", pno=" + pno + ", pic=" + pic + ", price="
				+ price + ", online=" + online + ", pdetail=" + pdetail + ", number=" + number + "]";
	}
	
}
