package com.neusoft.dao;

import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.Product_orderInfo;

public interface OrderInfoDao {
	/**
	 * 添加订单信息
	 */
	public Boolean addOrderInfo(Orderinfo ob) throws DaoException;
	
	/**
	 * 查询订单信息
	 * 根据订单编号
	 */
	public Orderinfo queryOrder(String orderno) throws DaoException;
	/**
	 * 副表添加商品id和订单id
	 */
	public Boolean addSAndOid(Product_orderInfo po) throws DaoException;
}
