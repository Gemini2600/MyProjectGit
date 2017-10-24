package com.neusoft.dao;

import com.neusoft.entity.CustGoodsBean;

public interface CusGoodsDao {

	/**
	 * 添加收货地址
	 * @param cb
	 * @return
	 * @throws PersonalException
	 */
	public CustGoodsBean addCusGoods(CustGoodsBean cb) throws DaoException;
	
	/**
	 * 查询收货地址
	 * 根据姓名
	 */
	public CustGoodsBean queryCus(String name) throws DaoException;
}
