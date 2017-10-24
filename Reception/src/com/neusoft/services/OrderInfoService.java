package com.neusoft.services;

import com.neusoft.dao.DaoException;
import com.neusoft.dao.OrderInfoDao;
import com.neusoft.dao.impl.OrderInfoDaoImpl;
import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.Product_orderInfo;
import com.neusoft.utils.DbUtil;

public class OrderInfoService {
	OrderInfoDao oid=DbUtil.getInstance("orderInfoDao", OrderInfoDaoImpl.class);
	/**
	 * 添加订单信息
	 */
	public Boolean addOrderInfo(Orderinfo ob) {
		return oid.addOrderInfo(ob);
	}
	
	/**
	 * 查询订单信息
	 * 根据订单编号
	 */
	public Orderinfo queryOrder(String orderno){
		return oid.queryOrder(orderno);
	}
	/**
	 * 副表添加商品id和订单id
	 */
	public Boolean addSAndOid(Product_orderInfo po) {
		return oid.addSAndOid(po);
	}
}
