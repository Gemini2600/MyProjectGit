package com.neusoft.dao;

import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.Product_orderInfo;

public interface OrderInfoDao {
	/**
	 * ��Ӷ�����Ϣ
	 */
	public Boolean addOrderInfo(Orderinfo ob) throws DaoException;
	
	/**
	 * ��ѯ������Ϣ
	 * ���ݶ������
	 */
	public Orderinfo queryOrder(String orderno) throws DaoException;
	/**
	 * ���������Ʒid�Ͷ���id
	 */
	public Boolean addSAndOid(Product_orderInfo po) throws DaoException;
}
