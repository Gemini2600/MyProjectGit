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
	 * ��Ӷ�����Ϣ
	 */
	public Boolean addOrderInfo(Orderinfo ob) {
		return oid.addOrderInfo(ob);
	}
	
	/**
	 * ��ѯ������Ϣ
	 * ���ݶ������
	 */
	public Orderinfo queryOrder(String orderno){
		return oid.queryOrder(orderno);
	}
	/**
	 * ���������Ʒid�Ͷ���id
	 */
	public Boolean addSAndOid(Product_orderInfo po) {
		return oid.addSAndOid(po);
	}
}
